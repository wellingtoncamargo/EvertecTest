package com.EvertecTest.util;

import com.github.javafaker.Faker;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Locale;

public class util {
    private static Faker rand = new Faker(new Locale("PT-BR"));

    public static JSONObject geraProdutos() throws JSONException {
        String title = rand.book().title();
        return new JSONObject()
                .put("title", title)
                .put("description", rand.book().publisher())
                .put("price", 45)
                .put("discountPercentage", 1.5)
                .put("rating", 7.5)
                .put("stock", 2)
                .put("brand", rand.book().author())
                .put("category", rand.book().genre())
                .put("category", rand.internet().image());
    }
}
