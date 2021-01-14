package com.example.phoenix;

public enum ModelObject {

    //Defining Pages
    EASY_STUDY(R.string.welcome_layout, R.layout.welcome_to_our_application),
    EASY_LEARNING(R.string.easy_learning, R.layout.easy_learning),
    EASY_TEACHING(R.string.easy_teaching, R.layout.easy_teaching);

    private int titleResId;
    private int layoutResId;

    ModelObject(int titleResId , int layoutResId){
        this.titleResId = titleResId;
        this.layoutResId = layoutResId;
    }

    public int getTitleResId() {
        return titleResId;
    }

    public int getLayoutResId() {
        return layoutResId;
    }
}
