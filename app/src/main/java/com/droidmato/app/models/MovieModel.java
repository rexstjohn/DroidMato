package com.droidmato.app.models;

import java.util.List;

/*
    "id": "770687943",
    "title": "Harry Potter and the Deathly Hallows - Part 2",
    "year": 2011,
    "mpaa_rating": "PG-13",
    "runtime": 130,
    "critics_consensus": "Thrilling, powerfully acted, and visually dazzling, Deathly Hallows Part II brings the Harry Potter franchise to a satisfying -- and suitably magical -- conclusion.",
    "release_dates": {"theater": "2011-07-15"},
    "ratings": {
      "critics_rating": "Certified Fresh",
      "critics_score": 97,
      "audience_rating": "Upright",
      "audience_score": 93
    },
    "synopsis": "Harry Potter and the Deathly Hallows - Part 2, is the final adventure in the Harry Potter film series. The much-anticipated motion picture event is the second of two full-length parts. In the epic finale, the battle between the good and evil forces of the wizarding world escalates into an all-out war. The stakes have never been higher and no one is safe. But it is Harry Potter who may be called upon to make the ultimate sacrifice as he draws closer to the climactic showdown with Lord Voldemort. It all ends here. -- (C) Warner Bros",
    "posters": {
      "thumbnail": "http://content8.flixster.com/movie/11/15/86/11158674_mob.jpg",
      "profile": "http://content8.flixster.com/movie/11/15/86/11158674_pro.jpg",
      "detailed": "http://content8.flixster.com/movie/11/15/86/11158674_det.jpg",
      "original": "http://content8.flixster.com/movie/11/15/86/11158674_ori.jpg"
    },
    "abridged_cast": [
      {
        "name": "Daniel Radcliffe",
        "characters": ["Harry Potter"]
      },
      {
        "name": "Rupert Grint",
        "characters": [
          "Ron Weasley",
          "Ron Wesley"
        ]
      },
      {
        "name": "Emma Watson",
        "characters": ["Hermione Granger"]
      },
      {
        "name": "Helena Bonham Carter",
        "characters": ["Bellatrix Lestrange"]
      },
      {
        "name": "Ralph Fiennes",
        "characters": ["Lord Voldemort"]
      }
    ],
    "alternate_ids": {"imdb": "1201607"},
    "links": {
      "self": "http://api.rottentomatoes.com/api/public/v1.0/movies/770687943.json",
      "alternate": "http://www.rottentomatoes.com/m/harry_potter_and_the_deathly_hallows_part_2/",
      "cast": "http://api.rottentomatoes.com/api/public/v1.0/movies/770687943/cast.json",
      "clips": "http://api.rottentomatoes.com/api/public/v1.0/movies/770687943/clips.json",
      "reviews": "http://api.rottentomatoes.com/api/public/v1.0/movies/770687943/reviews.json",
      "similar": "http://api.rottentomatoes.com/api/public/v1.0/movies/770687943/similar.json"
    }
 */
public class MovieModel {

    private int id;
    private String title;
    private int year;
    private String mpaa_rating;
    private int runtime;
    private String critics_consensus;
    private String synopsis;

    // Posters.
    private PosterModel posters;

    // Movies links.
    private MovieLinksModel links;

    // Ratings
    private MovieRatingsModel ratings;

    // Cast.
    private List<CastModel> abridged_cast;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getMpaa_rating() {
        return mpaa_rating;
    }

    public void setMpaa_rating(String mpaa_rating) {
        this.mpaa_rating = mpaa_rating;
    }

    public int getRuntime() {
        return runtime;
    }

    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }

    public String getCritics_consensus() {
        return critics_consensus;
    }

    public void setCritics_consensus(String critics_consensus) {
        this.critics_consensus = critics_consensus;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public PosterModel getPosters() {
        return posters;
    }

    public void setPosters(PosterModel posters) {
        this.posters = posters;
    }

    public MovieLinksModel getLinks() {
        return links;
    }

    public void setLinks(MovieLinksModel links) {
        this.links = links;
    }

    public MovieRatingsModel getRatings() {
        return ratings;
    }

    public void setRatings(MovieRatingsModel ratings) {
        this.ratings = ratings;
    }

    public List<CastModel> getAbridged_cast() {
        return abridged_cast;
    }

    public void setAbridged_cast(List<CastModel> abridged_cast) {
        this.abridged_cast = abridged_cast;
    }
}
