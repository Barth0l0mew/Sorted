package model;

import net.datafaker.Faker;
import net.datafaker.providers.base.Text;

import java.io.Serializable;

import static net.datafaker.providers.base.Text.DIGITS;
import static net.datafaker.providers.base.Text.EN_UPPERCASE;

public class User implements Serializable {
    private String userName;
    private String userPassword;
    private String userUrl;

    private User(BuilderUser builderUser) {
        this.userName = builderUser.userName;
        this.userPassword = builderUser.userPassword;
        this.userUrl = builderUser.userUrl;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public String getUserUrl() {
        return userUrl;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userUrl='" + userUrl + '\'' +
                '}';
    }

    public static User[] randomUser(int count) {
        User[] users = new User[count];
        Faker faker = new Faker();
        for (int i = 0; i < count; i++) {
            users[i] = new User.BuilderUser()
                    .setUserName(faker.name().name())
                    .setUserPassword(faker.text().text(Text.TextSymbolsBuilder.builder()
                            .len(8).with(EN_UPPERCASE, 2).
                            with(DIGITS, 3)
                            .build()))
                    .setUserUrl(faker.company().url())
                    .build();
        }
        return users;
    }

    public static class BuilderUser {
        private String userName;
        private String userPassword;
        private String userUrl;

        public BuilderUser setUserName(String userName) {
            this.userName = userName;
            return this;
        }

        public BuilderUser setUserPassword(String userPassword) {
            this.userPassword = userPassword;
            return this;
        }

        public BuilderUser setUserUrl(String userUrl) {
            this.userUrl = userUrl;
            return this;
        }

        private boolean equalsBuilder() {
            return (!this.userName.isBlank() && !this.userPassword.isBlank() && !this.userUrl.isBlank());
        }

        public User build() {
            if (equalsBuilder()) {
                return new User(this);
            } else {
                System.out.println("Invalid object bus");
                return null;
            }
        }
    }


}
