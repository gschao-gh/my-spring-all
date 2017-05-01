package com.ef.unit01;

/**
 * Created by Administrator on 2017/2/25.
 * 遇到多个构造器参数时要考虑使用构造器
 */
public class BuilderTechnologer {
    private final int servingSize;  //必须
    private final int fat;
    private final int sodium;
    private final int servings;

    public static class Bulider{

        private final int servingSize;
        private final int serving;

        private int calories =0;
        private int fat = 0;
        private int carbohydrate = 0;
        private int sodium = 0;

        public Bulider(int servingSize, int serving) {
            this.servingSize = servingSize;
            this.serving = serving;
        }


        public int getServingSize() {
            return servingSize;
        }

        public int getServing() {
            return serving;
        }

        public int getCalories() {
            return calories;
        }

        public void setCalories(int calories) {
            this.calories = calories;
        }

        public int getFat() {
            return fat;
        }

        public void setFat(int fat) {
            this.fat = fat;
        }

        public int getCarbohydrate() {
            return carbohydrate;
        }

        public void setCarbohydrate(int carbohydrate) {
            this.carbohydrate = carbohydrate;
        }

        public int getSodium() {
            return sodium;
        }

        public void setSodium(int sodium) {
            this.sodium = sodium;
        }
    }


    public BuilderTechnologer(Bulider builder) {
        this.servingSize = builder.getServingSize();
        this.servings = builder.getServing();
        this.fat = builder.getFat();
        this.sodium = builder.getSodium();
    }
}
