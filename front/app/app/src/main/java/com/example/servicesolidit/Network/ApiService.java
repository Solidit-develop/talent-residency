package com.example.servicesolidit.Network;



import com.example.servicesolidit.Utils.Models.Requests.LoginRequestDto;
import com.example.servicesolidit.Utils.Models.Requests.RegisterRequestDto;
import com.example.servicesolidit.Utils.Models.Requests.SendMessageRequest;
import com.example.servicesolidit.Utils.Models.Requests.UpdateToProviderRequestDto;
import com.example.servicesolidit.Utils.Models.Responses.Conversatoins.ConversationResponseDto;
import com.example.servicesolidit.Utils.Models.Responses.Feed.FeedResponseDto;
import com.example.servicesolidit.Utils.Models.Responses.LoginResponseDto;
import com.example.servicesolidit.Utils.Models.Responses.Messages.MessagesResponseDto;
import com.example.servicesolidit.Utils.Models.Responses.Messages.SendMessageResponseDto;
import com.example.servicesolidit.Utils.Models.Responses.RegisterResponseDto;
import com.example.servicesolidit.Utils.Models.Responses.User.UpdateUserToProviderResponseDto;
import com.example.servicesolidit.Utils.Models.Responses.User.UserInfoProfileResponseDto;
import com.example.servicesolidit.Utils.Models.Responses.User.UserInfoProviderProfileResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiService {
    @POST("users/login")
    Call<LoginResponseDto> login(@Body LoginRequestDto request);

    @POST("users/register")
    Call<RegisterResponseDto> register(@Body RegisterRequestDto request);

    @GET("users/information/{idToFind}")
    Call<UserInfoProfileResponseDto> information(@Path("idToFind")int idUserToFind);

    @POST("provider/correo")
    Call<RegisterResponseDto> updateToUserProvider(@Body UpdateToProviderRequestDto request);

    @GET("provider/provider/profile/{idToFind}")
    Call<UserInfoProviderProfileResponse> informationProvider(@Path("idToFind")int idUserToFind);

    @GET("provider/todos/services/feed")
    Call<FeedResponseDto> feed();

    @GET("message/mensajes/{idOrigen}/{idDestino}")
    Call<MessagesResponseDto> getMessages(@Path("idOrigen") int idOrigen, @Path("idDestino") int idDestino);

    @GET("message/mensajes/{idLogged}")
    Call<List<ConversationResponseDto>> getConversations(@Path("idLogged")int idLogged);

    @POST("message/mensajes/{idOrigen}/{idDestino}")
    Call<SendMessageResponseDto> sendMessages(@Path("idOrigen") int idOrigen, @Path("idDestino") int idDestino, @Body SendMessageRequest requestDto);
}
