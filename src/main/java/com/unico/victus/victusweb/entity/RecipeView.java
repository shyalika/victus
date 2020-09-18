package com.unico.victus.victusweb.entity;

public class RecipeView {

    private Page page;

    private String image;

    public RecipeView(Page page, String image) {
        this.page = page;
        this.image = image;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

}
