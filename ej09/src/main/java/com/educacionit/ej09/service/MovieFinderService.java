package com.educacionit.ej09.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.educacionit.ej09.dto.MovieDTO;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

@Service
public class MovieFinderService {
	
	private static final String URLLISTMOVIES = "https://yts.mx/api/v2/list_movies.json?query_term=";
	
	JSONObject jsonObject = new JSONObject();
	JSONArray jsonArray;

	public List<MovieDTO> getMoviesByName(String movieName) {
		List<MovieDTO> movies = new ArrayList<MovieDTO>();
		jsonObject = gerMoviesFromExternalAPI(URLLISTMOVIES, movieName);
		jsonArray = jsonObject.getJSONArray("movies");
		for(int i=0;i<jsonArray.length();i++) {
			MovieDTO movieDTO = new MovieDTO();
			movieDTO.setId(jsonArray.getJSONObject(i).getLong("id"));
			movieDTO.setName(jsonArray.getJSONObject(i).getString("title"));
			movieDTO.setSummary(jsonArray.getJSONObject(i).getString("summary"));
			movieDTO.setCover(jsonArray.getJSONObject(i).getString("medium_cover_image"));
			movies.add(movieDTO);
			System.out.println(jsonArray.getJSONObject(i).toString());
		}
		return movies;
	}
	
	private JSONObject gerMoviesFromExternalAPI(String url, String data) {
		OkHttpClient httpClient = new OkHttpClient();
		Request request = new Request.Builder().url(url+data).build();
		Call call = httpClient.newCall(request);
		Response response;
		try {
			response = call.execute();
			jsonObject = new JSONObject(response.body().string());
			if(jsonObject.get("status").equals("ok")) {
				jsonObject = jsonObject.getJSONObject("data");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return jsonObject;
		
	}

}
