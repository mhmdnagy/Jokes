/*
   For step-by-step instructions on connecting your Android application to this backend module,
   see "App Engine Java Endpoints Module" template documentation at
   https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloEndpoints
*/

package com.example.vezikon.jokes.backend;

import com.example.JokesSupplier;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.google.appengine.repackaged.com.google.gson.JsonArray;
import com.google.appengine.repackaged.com.google.gson.JsonObject;

/** An endpoint class we are exposing */
@Api(
  name = "myApi",
  version = "v1",
  namespace = @ApiNamespace(
    ownerDomain = "backend.jokes.vezikon.com",
    ownerName = "backend.jokes.vezikon.com",
    packagePath=""
  )
)
public class MyEndpoint {

    @ApiMethod(name = "getJokes")
    public Joke getJokes(){
        JokesSupplier supplier = new JokesSupplier();
        Joke response = new Joke();
        JsonArray jsonArray = new JsonArray();
        for(com.example.Joke joke: supplier.getJokes()){
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("Joke", joke.getJoke());
            jsonObject.addProperty("clue", joke.getClue());
            jsonArray.add(jsonObject);
        }
        response.setData(jsonArray.toString());
        return response;
    }

}
