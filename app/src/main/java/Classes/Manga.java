package Classes;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class Manga implements Parcelable {

    private int id;
    private String title;
    private ArrayList<String> alternativeTitles;
    private ArrayList<String> authors;
    private ArrayList<String> artists;
    private String posterPicture;//link
    private ArrayList<String> picturesFromSources;
    private String status;//ongoing, planToRead, dropped,completed   enum ?  with ongoing-completed-want to read- dropped
    private String dateStarted;// use date?
    private String dateEndedOrUpdated;
    private ArrayList<String> tags;
    private double lastChapterRead;
    private int totalChapters;
    private ArrayList<String> sourcesMangaSites; // array sources?
    private boolean isInMAL; //is the manga listen in My anime List (mal)
    private boolean updateOnMalIfExist;
    //private int rankedOnsource //if ranking excist on selected source


    public String getDescriptionOfManga() {
        return descriptionOfManga;
    }

    public void setDescriptionOfManga(String descriptionOfManga) {
        this.descriptionOfManga = descriptionOfManga;
    }

    private String descriptionOfManga;

    public double getLastChapterRead() {
        return lastChapterRead;
    }

    public void setLastChapterRead(double lastChapterRead) {
        this.lastChapterRead = lastChapterRead;
    }

    public int getTotalChapters() {
        return totalChapters;
    }

    public void setTotalChapters(int totalChapters) {
        this.totalChapters = totalChapters;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<String> getAlternativeTitles() {
        return alternativeTitles;
    }

    public void setAlternativeTitles(ArrayList<String> alternativeTitles) {
        this.alternativeTitles = alternativeTitles;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isInMAL() {
        return isInMAL;
    }

    public void setInMAL(boolean inMAL) {
        isInMAL = inMAL;
    }

    public ArrayList<String> getAuthors() {
        return authors;
    }

    public void setAuthors(ArrayList<String> authors) {
        this.authors = authors;
    }

    public ArrayList<String> getArtists() {
        return artists;
    }

    public void setArtists(ArrayList<String> artists) {
        this.artists = artists;
    }

    public ArrayList<String> getTags() {
        return tags;
    }

    public void setTags(ArrayList<String> tags) {
        this.tags = tags;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDateStarted() {
        return dateStarted;
    }

    public void setDateStarted(String dateStarted) {
        this.dateStarted = dateStarted;
    }

    public String getDateEndedOrUpdated() {
        return dateEndedOrUpdated;
    }

    public void setDateEndedOrUpdated(String dateEndedOrUpdated) {
        this.dateEndedOrUpdated = dateEndedOrUpdated;
    }

    public ArrayList<String> getSourcesMangaSites() {
        return sourcesMangaSites;
    }

    public void setSourcesMangaSites(ArrayList<String> sourcesMangaSites) {
        this.sourcesMangaSites = sourcesMangaSites;
    }

    public boolean isUpdateOnMalIfExist() {
        return updateOnMalIfExist;
    }

    public void setUpdateOnMalIfExist(boolean updateOnMalIfExist) {
        this.updateOnMalIfExist = updateOnMalIfExist;
    }

    public ArrayList<String> getPicturesFromSources() {
        return picturesFromSources;
    }

    public void setPicturesFromSources(ArrayList<String> picturesFromSources) {
        this.picturesFromSources = picturesFromSources;
    }

    public String getPosterPicture() {
        return posterPicture;
    }

    public void setPosterPicture(String posterPicture) {
        this.posterPicture = posterPicture;
    }

    public Manga(double lastChapterRead, int totalChapters, String title, ArrayList<String> alternativeTitles, int id, boolean isInMAL, ArrayList<String> authors, ArrayList<String> artists, ArrayList<String> tags, String status, String dateStarted, String dateEndedOrUpdated, ArrayList<String> sourcesMangaSites, boolean updateOnMalIfExist, ArrayList<String> picturesFromSources, String posterPicture, String descriptionOfManga) {
        this.lastChapterRead = lastChapterRead;
        this.totalChapters = totalChapters;
        this.title = title;
        this.alternativeTitles = alternativeTitles;
        this.id = id;
        this.isInMAL = isInMAL;
        this.authors = authors;
        this.artists = artists;
        this.tags = tags;
        this.status = status;
        this.dateStarted = dateStarted;
        this.dateEndedOrUpdated = dateEndedOrUpdated;
        this.sourcesMangaSites = sourcesMangaSites;
        this.updateOnMalIfExist = updateOnMalIfExist;
        this.picturesFromSources = picturesFromSources;
        this.posterPicture = posterPicture;
        this.descriptionOfManga = descriptionOfManga;
    }

    public Manga(Parcel source) { //DONT FORGET variables same spot as write
        this.id = source.readInt();
        this.title = source.readString();
        this.authors = source.readArrayList(null);
        this.artists = source.readArrayList(null);
        this.descriptionOfManga = source.readString();
        this.posterPicture = source.readString();


        this.lastChapterRead = source.readDouble();
        this.totalChapters = source.readInt();
        this.alternativeTitles = source.readArrayList(null);
        this.isInMAL = source.readInt() == 1;
        this.tags = source.readArrayList(null);
        this.status = source.readString();
        this.dateStarted = source.readString();
        this.dateEndedOrUpdated = source.readString();
        this.sourcesMangaSites = source.readArrayList(null);
        this.updateOnMalIfExist = source.readInt() == 1;//so i need to check this for 1 or 0??
        this.picturesFromSources = source.readArrayList(null);

    }

    public Manga() {

    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {//DONT FORGET variables same spot as read
        parcel.writeInt(id);
        parcel.writeString(title);
        parcel.writeList(authors);
        parcel.writeList(artists);
        parcel.writeString(descriptionOfManga);
        parcel.writeString(posterPicture);

        parcel.writeDouble(lastChapterRead);
        parcel.writeInt(totalChapters);
        parcel.writeList(alternativeTitles);
        parcel.writeInt(isInMAL ? 1 : 0);
        parcel.writeList(tags);
        parcel.writeString(status);
        parcel.writeString(dateStarted);
        parcel.writeString(dateEndedOrUpdated);
        parcel.writeList(sourcesMangaSites);
        parcel.writeInt(updateOnMalIfExist ? 1 : 0);
        parcel.writeList(picturesFromSources);


    }

    public static Creator<Manga> CREATOR = new Creator<Manga>() {
        @Override
        public Manga createFromParcel(Parcel parcel) {
            return new Manga(parcel);
        }

        @Override
        public Manga[] newArray(int size) {
            return new Manga[size];
        }
    };


}
