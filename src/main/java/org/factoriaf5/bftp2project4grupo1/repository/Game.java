package org.factoriaf5.bftp2project4grupo1.repository;

import javax.persistence.*;
import java.io.Serializable;
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
        private double priceWithDiscount;
        private String pegi;
        private String contentDescriptor;

        public Game() {

        }

        public Game(String title, String platform, int year, String imageUrl, String category, double price, double priceWithDiscount, String pegi, String contentDescriptor) {

            this.title = title;
            this.platform = platform;
            this.year = year;
            this.imageUrl = imageUrl;
            this.category = category;
            this.price = price;
            this.priceWithDiscount = priceWithDiscount;
            this.pegi = pegi;
            this.contentDescriptor = contentDescriptor;
        }

        public double getPriceWithDiscount() {
            return priceWithDiscount;
        }

        public void setPriceWithDiscount(double priceWithDiscount) {
            this.priceWithDiscount = priceWithDiscount;
        }

        public String getContentDescriptor() {
            return contentDescriptor;
        }

        public void setContentDescriptor(String contentDescriptor) {
            this.contentDescriptor = contentDescriptor;
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

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
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
                    ", contentDescriptor='" + contentDescriptor + '\'' +
                    '}';
        }
    }

