package com.example.rndroid.content_provider_application2_eg1;

import android.net.Uri;

/**
 * Created by rndroid on 29/1/17.
 */

//THIS FILE WILL WE VISIBLE TO OUTSIDE WORLD
// URI - Uniform Resource Identifier
//Step 4 -  declare column names and prepare URIs for your table
public class Uri_Provider {
    // column names for first tables
    public static final String _ID = "_id";
    public static final String NAME = "sname";
    public static final String SUB = "ssub";

    // prepare URI for student information table, other application will use below uri to read data from student table
    public static final Uri STUDENT_URI =
            Uri.parse("content://com.example.rndroid/student");
}
