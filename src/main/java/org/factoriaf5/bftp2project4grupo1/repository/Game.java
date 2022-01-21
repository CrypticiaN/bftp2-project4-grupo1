package org.factoriaf5.bftp2project4grupo1.repository;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

    @Entity
    @Table(name = "games")
    public class Game implements Serializable {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String title;
        private String platform;
        private int year;
        private String imageUrl;
        private String category;
        private double price;
        private int discount;
        private double priceWithDiscount;
        private String pegi;


        public Game() {

        }

        public Game(String title, String platform, int year, String imageUrl, String category, double price, int discount, double priceWithDiscount, String pegi) {
            this.title = title;
            this.platform = platform;
            this.year = year;
            this.imageUrl = imageUrl;
            this.category = category;
            this.price = price;
            this.discount = discount;
            this.priceWithDiscount = priceWithDiscount;
            this.pegi = pegi;

        }

        public String getContentDescriptor() {
            String contentDescriptor;
            switch (pegi) {
                case "3":
                    contentDescriptor = "suitable for kids";
                    break;
                case "7":
                    contentDescriptor = "suitable for all ages";
                    break;
                case "12":
                    contentDescriptor = "non-realistic violence";
                    break;
                case "16":
                    contentDescriptor = "realistic violence";
                    break;
                case "18":
                    contentDescriptor = "extreme violence";
                    break;
                default:
                    contentDescriptor = "no tiene ninguna descripción";
                    break;
            }
            return contentDescriptor;
        }



        public Long getId() {
            return id;
        }

        public String getCategory() {
            return category;
        }

        public String getPegi() {
            return pegi;
        }

        public void setCategory(String category) {
            this.category = category;
        }

        public void setPegi(String pegi) {
            this.pegi = pegi;
        }

        public void setId(Long id) {
            this.id = id;
        }


        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getPlatform() {
            return platform;
        }

        public void setPlatform(String platform) {
            this.platform = platform;
        }

        public int getYear() {
            return year;
        }

        public void setYear(int year) {
            this.year= year;
        }

        public  double getPrice() {
            return price;
        }


        public void setPrice( double price) {
            this.price = price;
        }


        public int getDiscount() {
            return discount;
        }

        public void setDiscount(int discount) {
            this.discount = discount;
        }

        public  double getPriceWithDiscount() {
            double d =  ((getPrice()) - (getPrice() *  getDiscount()/100));
            BigDecimal bd = new BigDecimal(d).setScale(2, RoundingMode.HALF_EVEN);
            return bd.doubleValue();
        }

        public void setPriceWithDiscount( double priceWithDiscount) {
            this.priceWithDiscount = priceWithDiscount;
        }


        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Game game = (Game) o;
            return Objects.equals(id, game.id) && Objects.equals(title, game.title) && Objects.equals(platform, game.platform) && Objects.equals(year, game.year);
        }


        @Override
        public int hashCode() {
            return Objects.hash(id, title, platform, year);
        }

        public String getImageUrl() {
            return imageUrl;
        }

        public void setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
        }

        @Override
        public String toString() {
            return "Game{" +
                    "id=" + id +
                    ", title='" + title + '\'' +
                    ", platform='" + platform + '\'' +
                    ", year=" + year +
                    ", imageUrl='" + imageUrl + '\'' +
                    ", category='" + category + '\'' +
                    ", price=" + price +
                    ", priceWithDiscount=" + priceWithDiscount +
                    ", pegi='" + pegi + '\'' +
                    '}';
        }

        public boolean isDiscounted() {
            return getPriceWithDiscount() < getPrice();
        }


    }

