package dao;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import java.io.IOException;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

public class FormularioD {

    public void getSheet() throws IOException, Exception {
        HttpClient httpClient = new DefaultHttpClient();
        try {
            StringEntity body = new StringEntity("{\"Url\": \"http://cosmeticdentistofmichigan.com/wp-content/uploads/2011/05/shutterstock_59848516.jpg\"}");
            JsonParser converter = new JsonParser();
            String emocion[] = "anger,contempt,disgust,fear,happiness,neutral,sadness,surprise".split(",");
            HttpPost request = new HttpPost("https://eastus.api.cognitive.microsoft.com/face/v1.0/detect?returnFaceId=true&returnFaceLandmarks=false&returnFaceAttributes=age,gender,smile,facialHair,glasses,emotion,hair,makeup,occlusion,accessories");
            request.addHeader("Ocp-Apim-Subscription-Key", "3be43f81dc7041cfab56a37c658f72cb");
            request.addHeader("Content-Type", "application/json");
            request.setEntity(body);
            HttpResponse response = httpClient.execute(request);
            HttpEntity entity = response.getEntity();

            JsonArray array = converter.parse(EntityUtils.toString(entity)).getAsJsonArray();
            JsonObject object = array.get(0).getAsJsonObject();
            JsonObject attributes = object.getAsJsonObject("faceAttributes");
            JsonObject emotion = attributes.getAsJsonObject("emotion");
            JsonObject velloCara = attributes.getAsJsonObject("facialHair");
            JsonObject maquillaje = attributes.getAsJsonObject("makeup");
            JsonObject pelo = attributes.getAsJsonObject("hair");
            JsonArray colorPelo = pelo.getAsJsonArray("hairColor");
            String lentes = attributes.get("glasses").getAsString();
            String edad = attributes.get("age").getAsString();
            String genero = attributes.get("gender").getAsString();
            String bigote = velloCara.get("moustache").getAsString();
            String barba = velloCara.get("beard").getAsString();
            String patillas = velloCara.get("sideburns").getAsString();
            String ojosPintados = maquillaje.get("eyeMakeup").getAsString();
            String labiosPintados = maquillaje.get("lipMakeup").getAsString();
            String calvo = pelo.get("bald").getAsString();
            String invisible = pelo.get("invisible").getAsString();
            String nameEmotion = null;
            int valueEmotion = 0;

            for (String valores : emocion) {
                if (valueEmotion < emotion.get(valores).getAsInt()) {
                    nameEmotion = valores;
                    valueEmotion = emotion.get(valores).getAsInt();
                }
            }

            JsonObject colores = null;
            for (JsonElement jsonElement : colorPelo) {
                if (colores == null) {
                    colores = jsonElement.getAsJsonObject();
                } else {
                    if (colores.get("confidence").getAsDouble() > jsonElement.getAsJsonObject().get("confidence").getAsDouble()) {
                        colores = jsonElement.getAsJsonObject();
                    }
                }
            }
            String colorPerlo = colores.get("color").getAsString();
//            System.out.println(json1);
            System.out.println("Emoción: " + nameEmotion);
            System.out.println("Bigote: " + bigote);
            System.out.println("Barba: " + barba);
            System.out.println("Patillas: " + patillas);
            System.out.println("lentes: " + lentes);
            System.out.println("edad: " + edad);
            System.out.println("Género: " + genero);
            System.out.println("Ojos Pintados: " + ojosPintados);
            System.out.println("Labios Pintados: " + labiosPintados);
            System.out.println("Calvo: " + calvo);
            System.out.println("Invisible: " + invisible);
            System.out.println("Color de pelo: " + colorPerlo);
        } catch (IOException e) {
            throw e;
        }
    }

    public static void main(String[] args) throws IOException {
        HttpClient httpClient = new DefaultHttpClient();
        try {
            StringEntity body = new StringEntity("{\"Url\": \"http://cosmeticdentistofmichigan.com/wp-content/uploads/2011/05/shutterstock_59848516.jpg\"}");
            JsonParser converter = new JsonParser();
            String emocion[] = "anger,contempt,disgust,fear,happiness,neutral,sadness,surprise".split(",");
            HttpPost request = new HttpPost("https://eastus.api.cognitive.microsoft.com/face/v1.0/detect?returnFaceId=true&returnFaceLandmarks=false&returnFaceAttributes=age,gender,smile,facialHair,glasses,emotion,hair,makeup,occlusion,accessories");
            request.addHeader("Ocp-Apim-Subscription-Key", "3be43f81dc7041cfab56a37c658f72cb");
            request.addHeader("Content-Type", "application/json");
            request.setEntity(body);
            HttpResponse response = httpClient.execute(request);
            HttpEntity entity = response.getEntity();

            JsonArray array = converter.parse(EntityUtils.toString(entity)).getAsJsonArray();
            JsonObject object = array.get(0).getAsJsonObject();
            JsonObject attributes = object.getAsJsonObject("faceAttributes");
            JsonObject emotion = attributes.getAsJsonObject("emotion");
            JsonObject velloCara = attributes.getAsJsonObject("facialHair");
            JsonObject maquillaje = attributes.getAsJsonObject("makeup");
            JsonObject pelo = attributes.getAsJsonObject("hair");
            JsonArray colorPelo = pelo.getAsJsonArray("hairColor");
            String lentes = attributes.get("glasses").getAsString();
            String edad = attributes.get("age").getAsString();
            String genero = attributes.get("gender").getAsString();
            String bigote = velloCara.get("moustache").getAsString();
            String barba = velloCara.get("beard").getAsString();
            String patillas = velloCara.get("sideburns").getAsString();
            String ojosPintados = maquillaje.get("eyeMakeup").getAsString();
            String labiosPintados = maquillaje.get("lipMakeup").getAsString();
            String calvo = pelo.get("bald").getAsString();
            String invisible = pelo.get("invisible").getAsString();
            String nameEmotion = null;
            int valueEmotion = 0;

            for (String valores : emocion) {
                if (valueEmotion < emotion.get(valores).getAsInt()) {
                    nameEmotion = valores;
                    valueEmotion = emotion.get(valores).getAsInt();
                }
            }

            JsonObject colores = null;
            for (JsonElement jsonElement : colorPelo) {
                if (colores == null) {
                    colores = jsonElement.getAsJsonObject();
                } else {
                    if (colores.get("confidence").getAsDouble() > jsonElement.getAsJsonObject().get("confidence").getAsDouble()) {
                        colores = jsonElement.getAsJsonObject();
                    }
                }
            }
            String colorPerlo = colores.get("color").getAsString();
//            System.out.println(json1);
            System.out.println("Emoción: " + nameEmotion);
            System.out.println("Bigote: " + bigote);
            System.out.println("Barba: " + barba);
            System.out.println("Patillas: " + patillas);
            System.out.println("lentes: " + lentes);
            System.out.println("edad: " + edad);
            System.out.println("Género: " + genero);
            System.out.println("Ojos Pintados: " + ojosPintados);
            System.out.println("Labios Pintados: " + labiosPintados);
            System.out.println("Calvo: " + calvo);
            System.out.println("Invisible: " + invisible);
            System.out.println("Color de pelo: " + colorPerlo);
        } catch (IOException e) {
            throw e;
        }
    }

}
