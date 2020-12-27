
package pl.zwolek.teaiweek7.catsnews.client.dtos;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "verified",
    "sentCount"
})
public class Status {

    @JsonProperty("verified")
    private Boolean verified;
    @JsonProperty("sentCount")
    private Integer sentCount;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("verified")
    public Boolean getVerified() {
        return verified;
    }

    @JsonProperty("verified")
    public void setVerified(Boolean verified) {
        this.verified = verified;
    }

    @JsonProperty("sentCount")
    public Integer getSentCount() {
        return sentCount;
    }

    @JsonProperty("sentCount")
    public void setSentCount(Integer sentCount) {
        this.sentCount = sentCount;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        return "Status{" +
                "verified=" + verified +
                ", sentCount=" + sentCount +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}
