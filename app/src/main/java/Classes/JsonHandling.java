package Classes;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class JsonHandling {


    private JSONObject fullJsonFile;
    private Context context;


    public JSONObject getFullJsonFile() {
        return fullJsonFile;
    }


    public JsonHandling(Context context) {
        this.context = context;
    }


    public String loadJSONFromAsset(Context context) {
       String fileName = "MangaBook json";

       String json =  null;
       try {
            InputStream is = context.getAssets().open(fileName);//.getAbsolutePath());
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

 
    //addMangaBookToCollectionUserJson

    @NonNull
    public JSONObject getWholeJsonFile() {
        try {
            String tempString = loadJSONFromAsset(context);
            fullJsonFile = new JSONObject(tempString);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fullJsonFile;
    }

    public ArrayList<Manga> getMangaBookJson(){
        fullJsonFile = getWholeJsonFile();
        ArrayList<Manga> mangaBooksArrayList = new ArrayList<Manga>() ;


        Log.i("MangaArrayList",fullJsonFile.toString());

        if(fullJsonFile != null || fullJsonFile.toString() != ""){
            try {
                JSONArray mangaBook = fullJsonFile.getJSONArray("Manga");
                for(int i= 0;i< mangaBook.length();i++){
                    Manga mangaToAdd = new Manga();

                    JSONObject mangaBookJsonObject = mangaBook.getJSONObject(i);

                    mangaToAdd.setId(mangaBookJsonObject.getInt("id"));

                    mangaToAdd.setTitle(mangaBookJsonObject.getString("title"));

                    ArrayList<String> alternativeTitles= new ArrayList<String>();
                    JSONArray arr1 = mangaBookJsonObject.getJSONArray("alternativeTitles");
                    for(int j =0; j< arr1.length();j++) {
                        String alternativeTitleString = arr1.getString(j);

                        alternativeTitles.add(alternativeTitleString);
                    }
                    mangaToAdd.setAlternativeTitles(alternativeTitles);

                    ArrayList<String> authors = new ArrayList<String>();
                    JSONArray arr2 = mangaBookJsonObject.getJSONArray("authors");
                    for(int k =0; k< arr2.length();k++) {
                        String authorsString = arr2.getString(k);
                        authors.add(authorsString);
                    }
                    mangaToAdd.setAuthors(authors);

                    ArrayList<String> artists = new ArrayList<String>();
                    JSONArray arr3 = mangaBookJsonObject.getJSONArray("artists");
                    for(int l =0; l< arr3.length();l++) {
                        String artistsString = arr3.getString(l);
                        artists.add(artistsString);
                    }
                    mangaToAdd.setArtists(artists);

                    mangaToAdd.setDescriptionOfManga(mangaBookJsonObject.getString("description"));

                    mangaToAdd.setPosterPicture(mangaBookJsonObject.getString("posterPicture"));//link

                    ArrayList<String> pictureFromSources = new ArrayList<String>();
                    JSONArray arr5 = mangaBookJsonObject.getJSONArray("pictureFromSources");
                    for(int p =0; p< arr5.length();p++) {
                        String pictureFromSourcesString = arr5.getString(p);
                        pictureFromSources.add(pictureFromSourcesString);
                    }
                    mangaToAdd.setPicturesFromSources(pictureFromSources);

                    mangaToAdd.setStatus(mangaBookJsonObject.getString("status"));
                    mangaToAdd.setDateStarted(mangaBookJsonObject.getString("dateStarted"));// use date?
                    mangaToAdd.setDateEndedOrUpdated(mangaBookJsonObject.getString("dateEndedOrUpdated"));


                    ArrayList<String> tags = new ArrayList<String>();
                    JSONArray arr7 = mangaBookJsonObject.getJSONArray("tags");
                    for(int r =0; r< arr7.length();r++) {
                        String tagsString = arr7.getString(r);
                        tags.add(tagsString);
                    }
                    mangaToAdd.setTags(tags);

                    mangaToAdd.setLastChapterRead(mangaBookJsonObject.getDouble("lastChapterRead"));
                    mangaToAdd.setTotalChapters(mangaBookJsonObject.getInt("totalChapter"));

                    ArrayList<String> sourcesMangaSites = new ArrayList<String>();
                    JSONArray arr6 = mangaBookJsonObject.getJSONArray("sourcesMangaSites");
                    for(int u =0; u< arr6.length();u++) {
                        String sourcesMangaSitesString = arr6.getString(u);
                        sourcesMangaSites.add(sourcesMangaSitesString);
                    }
                    mangaToAdd.setSourcesMangaSites(sourcesMangaSites);

                    mangaToAdd.setInMAL(mangaBookJsonObject.getBoolean("isInMal")); //is the manga listen in My anime List (mal)
                    mangaToAdd.setUpdateOnMalIfExist(mangaBookJsonObject.getBoolean("updateOnMalIfExist"));

                    mangaBooksArrayList.add(mangaToAdd);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }


        return mangaBooksArrayList;
    }


}
