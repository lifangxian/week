package com.example.www.week.bean;

import java.util.ArrayList;

public class Result {
    private ArrayList<LtemList> itemList;

    public ArrayList<LtemList> getItemList() {
        return itemList;
    }

    public void setItemList(ArrayList<LtemList> itemList) {
        this.itemList = itemList;
    }

    @Override
    public String toString() {
        return "Result{" +
                "itemList=" + itemList +
                '}';
    }
}
