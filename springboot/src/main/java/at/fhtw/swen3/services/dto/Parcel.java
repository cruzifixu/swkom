package at.fhtw.swen3.services.dto;

import java.util.Objects;

import at.fhtw.swen3.persistence.entities.RecipientEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.extern.slf4j.Slf4j;


import javax.annotation.Generated;

/**
 * Parcel
 */
@Slf4j
@JsonTypeName("parcel")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-09-24T14:48:00.085786Z[Etc/UTC]")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

public class Parcel {

  @JsonProperty("weight")
  private Float weight;

  @JsonProperty("recipient")
  private RecipientEntity recipient;

  @JsonProperty("sender")
  private RecipientEntity sender;

  // Tracking Id
  @JsonProperty("trackingId")
  private String trackingId;

  public Parcel weight(Float weight) {
    this.weight = weight;
    log.info("weight set to {}", this.weight);
    return this;
  }

  /**
   * Get weight
   * @return weight
  */
  @NotNull 
  @Schema(name = "weight", required = true)
  public Float getWeight() {
    return weight;
  }

  public void setWeight(Float weight) {
    this.weight = weight;
    log.info("weight set to {}", this.weight);
  }

  public Parcel recipient(RecipientEntity recipient) {
    this.recipient = recipient;
    log.info("recipient set to {}", this.recipient);
    return this;
  }

  /**
   * Get recipient
   * @return recipient
  */
  @Schema(name = "recipient", required = true)
  public @NotNull(message = "Recipient cannot be Null") RecipientEntity getRecipient() {
    return recipient;
  }

  public void setRecipient(RecipientEntity recipient) {
    this.recipient = recipient;
    log.info("recipient set to {}", this.recipient);
  }

  public Parcel sender(RecipientEntity sender) {
    this.sender = sender;
    log.info("sender set to {}", this.sender);
    return this;
  }

  /**
   * Get sender
   * @return sender
  */
  @Schema(name = "sender", required = true)
  public @NotNull(message = "Recipient cannot be Null") RecipientEntity getSender() {
    return sender;
  }

  public void setSender(RecipientEntity sender) {
    this.sender = sender;
    log.info("sender set to {}", this.sender);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Parcel parcel = (Parcel) o;
    return Objects.equals(this.weight, parcel.weight) &&
        Objects.equals(this.recipient, parcel.recipient) &&
        Objects.equals(this.sender, parcel.sender);
  }

  @Override
  public int hashCode() {
    return Objects.hash(weight, recipient, sender);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Parcel {\n");
    sb.append("    weight: ").append(toIndentedString(weight)).append("\n");
    sb.append("    recipient: ").append(toIndentedString(recipient)).append("\n");
    sb.append("    sender: ").append(toIndentedString(sender)).append("\n");
    sb.append("}");
    log.info("string builder:\n{}", sb);
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

