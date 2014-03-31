/*
 * Copyright (c) 2014 Rex St. John on behalf of AirPair.com
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.droidmato.app.adapters.items;

import android.net.Uri;

import com.droidmato.app.models.MovieModel;

/**
 * Used to represent a movie list item.
 *
 * Created by Rex St. John on 3/4/14.
 */
public class MovieListItem {

    // Ivars.
    private Uri fullImageUri;
    private MovieModel movieModel;

    public MovieListItem(MovieModel movieModel) {
        this.movieModel = movieModel;
        this.fullImageUri = Uri.parse(movieModel.getPosters().getDetailed());
    }

    /**
     * Getters and setters
     */

    public Uri getFullImageUri() {
        return fullImageUri;
    }

    public void setFullImageUri(Uri fullImageUri) {
        this.fullImageUri = fullImageUri;
    }

    public MovieModel getMovieModel() {
        return movieModel;
    }

    public void setMovieModel(MovieModel movieModel) {
        this.movieModel = movieModel;
    }

}
