package com.conurets.hcm.commons.base.dto.request;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * @author MSA
 * @version 1.0
 */

@Data
@EqualsAndHashCode(callSuper = false)
public class LookupSearchCriteriaRequestDTO extends BaseRequestDTO {
    @NotEmpty(message = "Query type must not be empty")
    @Size(min = 1, max = 200, message = "Query type must have valid format")
    private String queryType;
    private List<String> params;
}