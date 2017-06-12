# Retrofit Sample with Gson

Hey. This is a sample android app that shows you how to use Retrofit library together with Gson (JSON praser) library. Traditionally, you are good with AsyncTask while getting data from web service REST API.

## Why retrofit?
It's released by Square, This offers very easy and faster way to use REST API.
You will need to add these into *build.gradle* file.

```
//Retrofit
compile 'com.squareup.retrofit2:retrofit:2.0.2'
compile 'com.squareup.retrofit2:converter-gson:2.1.0'

//Gson
compile 'com.google.code.gson:gson:2.7'
```

To learn more tabout Retrofit, [Retrofit - Square Open Source](http://square.github.io/retrofit/).  

## Gson
Gson is another popular libary that people use it to combine with Retrofit for REST API. Gson is a Java library that can be used to convert Java Objects into their JSON representation. It can also be used to convert a JSON string to an equivalent Java object.

To learn more about GSON, [google-gson](https://github.com/google/gson).


## Credit
I am using a free web REST API call to demo this. It doesn't require any authentication at the moment.  
```https://api.openaq.org/v1/countries``` It is an API for open air quality data.
