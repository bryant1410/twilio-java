package com.twilio.sdk.resources.api.v2010.account.call;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.MoreObjects;
import com.twilio.sdk.clients.TwilioRestClient;
import com.twilio.sdk.converters.MarshalConverter;
import com.twilio.sdk.deleters.api.v2010.account.call.NotificationDeleter;
import com.twilio.sdk.exceptions.ApiConnectionException;
import com.twilio.sdk.exceptions.ApiException;
import com.twilio.sdk.fetchers.api.v2010.account.call.NotificationFetcher;
import com.twilio.sdk.http.HttpMethod;
import com.twilio.sdk.http.Request;
import com.twilio.sdk.http.Response;
import com.twilio.sdk.readers.api.v2010.account.call.NotificationReader;
import com.twilio.sdk.resources.RestException;
import com.twilio.sdk.resources.SidResource;
import org.joda.time.DateTime;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.Map;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Notification extends SidResource {
    private static final long serialVersionUID = 203437902819777L;

    /**
     * fetch
     * 
     * @param accountSid The account_sid
     * @param callSid The call_sid
     * @param sid The sid
     * @return NotificationFetcher capable of executing the fetch
     */
    public static NotificationFetcher fetch(final String accountSid, final String callSid, final String sid) {
        return new NotificationFetcher(accountSid, callSid, sid);
    }

    /**
     * delete
     * 
     * @param accountSid The account_sid
     * @param callSid The call_sid
     * @param sid The sid
     * @return NotificationDeleter capable of executing the delete
     */
    public static NotificationDeleter delete(final String accountSid, final String callSid, final String sid) {
        return new NotificationDeleter(accountSid, callSid, sid);
    }

    /**
     * read
     * 
     * @param accountSid The account_sid
     * @param callSid The call_sid
     * @return NotificationReader capable of executing the read
     */
    public static NotificationReader read(final String accountSid, final String callSid) {
        return new NotificationReader(accountSid, callSid);
    }

    /**
     * Converts a JSON String into a Notification object using the provided
     * ObjectMapper
     * 
     * @param json Raw JSON String
     * @param objectMapper Jackson ObjectMapper
     * @return Notification object represented by the provided JSON
     */
    public static Notification fromJson(final String json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Notification.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
     * Converts a JSON InputStream into a Notification object using the provided
     * ObjectMapper
     * 
     * @param json Raw JSON InputStream
     * @param objectMapper Jackson ObjectMapper
     * @return Notification object represented by the provided JSON
     */
    public static Notification fromJson(final InputStream json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Notification.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    private final String accountSid;
    private final String apiVersion;
    private final String callSid;
    private final DateTime dateCreated;
    private final DateTime dateUpdated;
    private final String errorCode;
    private final String log;
    private final DateTime messageDate;
    private final String messageText;
    private final URI moreInfo;
    private final HttpMethod requestMethod;
    private final URI requestUrl;
    private final String sid;
    private final String uri;
    private final String requestVariables;
    private final String responseBody;
    private final String responseHeaders;

    @JsonCreator
    private Notification(@JsonProperty("account_sid") final String accountSid, 
                         @JsonProperty("api_version") final String apiVersion, 
                         @JsonProperty("call_sid") final String callSid, 
                         @JsonProperty("date_created") final String dateCreated, 
                         @JsonProperty("date_updated") final String dateUpdated, 
                         @JsonProperty("error_code") final String errorCode, 
                         @JsonProperty("log") final String log, 
                         @JsonProperty("message_date") final String messageDate, 
                         @JsonProperty("message_text") final String messageText, 
                         @JsonProperty("more_info") final URI moreInfo, 
                         @JsonProperty("request_method") final HttpMethod requestMethod, 
                         @JsonProperty("request_url") final URI requestUrl, 
                         @JsonProperty("sid") final String sid, 
                         @JsonProperty("uri") final String uri, 
                         @JsonProperty("request_variables") final String requestVariables, 
                         @JsonProperty("response_body") final String responseBody, 
                         @JsonProperty("response_headers") final String responseHeaders) {
        this.accountSid = accountSid;
        this.apiVersion = apiVersion;
        this.callSid = callSid;
        this.dateCreated = MarshalConverter.dateTimeFromString(dateCreated);
        this.dateUpdated = MarshalConverter.dateTimeFromString(dateUpdated);
        this.errorCode = errorCode;
        this.log = log;
        this.messageDate = MarshalConverter.dateTimeFromString(messageDate);
        this.messageText = messageText;
        this.moreInfo = moreInfo;
        this.requestMethod = requestMethod;
        this.requestUrl = requestUrl;
        this.sid = sid;
        this.uri = uri;
        this.requestVariables = requestVariables;
        this.responseBody = responseBody;
        this.responseHeaders = responseHeaders;
    }

    /**
     * @return The account_sid
     */
    public final String getAccountSid() {
        return this.accountSid;
    }

    /**
     * @return The api_version
     */
    public final String getApiVersion() {
        return this.apiVersion;
    }

    /**
     * @return The call_sid
     */
    public final String getCallSid() {
        return this.callSid;
    }

    /**
     * @return The date_created
     */
    public final DateTime getDateCreated() {
        return this.dateCreated;
    }

    /**
     * @return The date_updated
     */
    public final DateTime getDateUpdated() {
        return this.dateUpdated;
    }

    /**
     * @return The error_code
     */
    public final String getErrorCode() {
        return this.errorCode;
    }

    /**
     * @return The log
     */
    public final String getLog() {
        return this.log;
    }

    /**
     * @return The message_date
     */
    public final DateTime getMessageDate() {
        return this.messageDate;
    }

    /**
     * @return The message_text
     */
    public final String getMessageText() {
        return this.messageText;
    }

    /**
     * @return The more_info
     */
    public final URI getMoreInfo() {
        return this.moreInfo;
    }

    /**
     * @return The request_method
     */
    public final HttpMethod getRequestMethod() {
        return this.requestMethod;
    }

    /**
     * @return The request_url
     */
    public final URI getRequestUrl() {
        return this.requestUrl;
    }

    /**
     * @return The sid
     */
    public final String getSid() {
        return this.sid;
    }

    /**
     * @return The uri
     */
    public final String getUri() {
        return this.uri;
    }

    /**
     * @return The request_variables
     */
    public final String getRequestVariables() {
        return this.requestVariables;
    }

    /**
     * @return The response_body
     */
    public final String getResponseBody() {
        return this.responseBody;
    }

    /**
     * @return The response_headers
     */
    public final String getResponseHeaders() {
        return this.responseHeaders;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        
        Notification other = (Notification) o;
        
        return Objects.equals(accountSid, other.accountSid) && 
               Objects.equals(apiVersion, other.apiVersion) && 
               Objects.equals(callSid, other.callSid) && 
               Objects.equals(dateCreated, other.dateCreated) && 
               Objects.equals(dateUpdated, other.dateUpdated) && 
               Objects.equals(errorCode, other.errorCode) && 
               Objects.equals(log, other.log) && 
               Objects.equals(messageDate, other.messageDate) && 
               Objects.equals(messageText, other.messageText) && 
               Objects.equals(moreInfo, other.moreInfo) && 
               Objects.equals(requestMethod, other.requestMethod) && 
               Objects.equals(requestUrl, other.requestUrl) && 
               Objects.equals(sid, other.sid) && 
               Objects.equals(uri, other.uri) && 
               Objects.equals(requestVariables, other.requestVariables) && 
               Objects.equals(responseBody, other.responseBody) && 
               Objects.equals(responseHeaders, other.responseHeaders);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountSid,
                            apiVersion,
                            callSid,
                            dateCreated,
                            dateUpdated,
                            errorCode,
                            log,
                            messageDate,
                            messageText,
                            moreInfo,
                            requestMethod,
                            requestUrl,
                            sid,
                            uri,
                            requestVariables,
                            responseBody,
                            responseHeaders);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                          .add("accountSid", accountSid)
                          .add("apiVersion", apiVersion)
                          .add("callSid", callSid)
                          .add("dateCreated", dateCreated)
                          .add("dateUpdated", dateUpdated)
                          .add("errorCode", errorCode)
                          .add("log", log)
                          .add("messageDate", messageDate)
                          .add("messageText", messageText)
                          .add("moreInfo", moreInfo)
                          .add("requestMethod", requestMethod)
                          .add("requestUrl", requestUrl)
                          .add("sid", sid)
                          .add("uri", uri)
                          .add("requestVariables", requestVariables)
                          .add("responseBody", responseBody)
                          .add("responseHeaders", responseHeaders)
                          .toString();
    }
}