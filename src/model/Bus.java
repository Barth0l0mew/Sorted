package model;

import net.datafaker.Faker;

import java.io.Serializable;

public class Bus implements Serializable {
    private String numberBus;
    private String modelBus;
    private String scoreBus;

    private Bus(BuilderBus builderBus) {
        this.numberBus = builderBus.numberBus;
        this.modelBus = builderBus.modelBus;
        this.scoreBus = builderBus.scoreBus;
    }
    public String getNumberBus() {
        return numberBus;
    }

    public String getModelBus() {
        return modelBus;
    }

    public String getScoreBus() {
        return scoreBus;
    }

    @Override
    public String toString() {
        return "Bus{" +
                "numberBus='" + numberBus + '\'' +
                ", modelBus='" + modelBus + '\'' +
                ", scoreBus='" + scoreBus + '\'' +
                '}';
    }

    public static Bus[] randomBus(int count) {
        Bus[] buss = new Bus[count];
        Faker faker = new Faker();
        for (int i = 0; i < count; i++) {
            buss[i] = new Bus.BuilderBus()
                    .setNumberBus(faker.expression("#{bothify '??-####','true'}"))
                    .setModelBus(faker.brand().car())
                    .setScoreBus(faker.code().ean8())
                    .build();
        }
        return buss;
    }

    public static class BuilderBus {
        private String numberBus;
        private String modelBus;
        private String scoreBus;

        public BuilderBus setNumberBus(String numberBus) {
            this.numberBus = numberBus;
            return this;
        }

        public BuilderBus setModelBus(String modelBus) {
            this.modelBus = modelBus;
            return this;
        }

        public BuilderBus setScoreBus (String scoreBus) {
            this.scoreBus = scoreBus;
            return this;
        }

        private boolean equalsBuilder() {
            return (!this.numberBus.isBlank() && !this.modelBus.isBlank() && !this.scoreBus.isBlank());
        }

        public Bus build() {
            if (equalsBuilder()) {
                return new Bus(this);
            } else {
                System.out.println("Invalid object bus");
                return null;
            }
        }
    }


}
