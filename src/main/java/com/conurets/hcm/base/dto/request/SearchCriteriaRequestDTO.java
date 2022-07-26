package com.conurets.hcm.base.dto.request;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author MSA
 * @version 1.0
 */

@Data
@EqualsAndHashCode(callSuper = false)
public class SearchCriteriaRequestDTO extends BaseRequestDTO {
    public static final String ASC = "ASC";
    public static final String DESC = "DESC";
    private String column;
    private String searchString;
    private int page;
    private int pageSize;
    private String sortColumn;
    private String sortOrder;
}