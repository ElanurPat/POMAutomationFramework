package com.nopcommerce.util;

import java.util.ArrayList;
import java.util.List;

public class Constants {
    public static final String PAGE_TITLE="nopCommerce demo store";
    public static final String LOGINPAGE_NAME="Welcome, Please Sign In!";
    public static final String SEARCHPAGE_NAME="Search";
    public static final String[] MANUFACTURE_DROPDOWN={"All","Apple","HP","Nike"};
    public static List<String>actualCategoryList(){
        List<String> list=new ArrayList<>();
        list.add("Computers");
        list.add("Electronics");
        list.add("Apparel");
        list.add("Digital downloads");
        list.add("Books");
        list.add("Jewelry");
        list.add("Gift Cards");
        return list;
    }
}
