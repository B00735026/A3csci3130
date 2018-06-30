package com.acme.a3csci3130;

import com.google.firebase.database.Exclude;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Class that defines how the data will be stored in the
 * Firebase databse. This is converted to a JSON format
 */

public class Contact implements Serializable {
    /**
     * uid user's id
     * name user's first name and last name
     * user's email address
     * bussiness_num user's business number
     * address is user's address
     * primary_business user's primary business
     * province is user's location
     */
    public String uid;
    public String name;
    public String email;
    public String bussiness_num;
    public String address;
    public String primary_business;
    public String province;
    public Contact() {
        // Default constructor required for calls to DataSnapshot.getValue
    }

    /**
     * Create a new user with the uid, name, email, business number, address, primary business number and province.
     * @param uid The unique uid created by Firebase.
     * @param name User's name. Length should between 2 and 48 characters.
     * @param email User'email address.
     * @param bussiness_num User's business number, it consist with 9-digit number.
     * @param address User's address. Length should less than 50 characters.
     * @param primary_business User's primary business. Only requires for {Fisher, Distributor, Processor, Fish Monger}.
     * @param province User's location of province. Province only requires for {AB,BC,MB,NB,NL.NS,NT,NU,ON,PE,QC,SK,YT}.
     */
    public Contact(String uid, String name, String email,String bussiness_num, String address, String primary_business, String province){
        this.uid = uid;
        this.name = name;
        this.email = email;
        this.bussiness_num = bussiness_num;
        this.address = address;
        this.primary_business = primary_business;
        this.province = province;

    }

    /**
     * Gets user's id .
     * @return this user's id.
     */
    public String getUid(){
        return uid;
    }

    /**
     * Gets the first name and last of this user.
     * @return this user's name.
     */
    public String getName(){
        return name;
    }

    /**
     * Gets the email address of this user.
     * @return this user's email.
     */
    public String getEmail(){
        return email;
    }

    /**
     * Gets the address of this user
     * @return this user's address
     */
    public String getAddress(){
        return address;
    }

    /**
     * Gets the primary business of this user
     * @return this user's primary business
     */
   public String getPrimary_business(){
        return primary_business;
   }

    /**
     * Gets the province of this user
     * @return this user's province
     */
   public String getProvince(){
        return province;
   }

    /**
     * Gets the business number of this user
     * @return this user's business number
     */
   public String getBussiness_num(){
        return bussiness_num;
   }

    @Exclude
    public Map<String, Object> toMap(){
        HashMap<String, Object> result = new HashMap<>();
        result.put("uid", uid);
        result.put("name", name);
        result.put("email", email);
        result.put("address", address);
        result.put("primary_business",primary_business);
        result.put("province",province);
        result.put("bussiness_number",bussiness_num);
        return result;
    }
}
