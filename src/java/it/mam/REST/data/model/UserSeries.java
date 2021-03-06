package it.mam.REST.data.model;

import java.util.Date;

/**
 *
 * @author alex
 */
public interface UserSeries {

    String ZERO = "0";
    String ONE = "1";
    String TWO = "2";
    String THREE = "3";
    String FOUR = "4";
    String FIVE = "5";

    int getID();

    User getUser();

    void setUser(User user);

    Series getSeries();

    void setSeries(Series series);

    String getRating();

    void setRating(String rating);

    Date getAnticipationNotification();

    void setAnticipationNotification(Date anticipation);

    Date getAddDate();

    void setAddDate(Date addDate);

    int getSeason();

    void setSeason(int season);

    int getEpisode();

    void setEpisode(int episode);

    boolean isDirty();

    void setDirty(boolean dirty);

    void copyFrom(UserSeries userSeries);

}
