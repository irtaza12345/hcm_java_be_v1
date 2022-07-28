package com.conurets.hcm.mapper;

import com.conurets.hcm.base.dto.request.AddErrorCodeRequestDTO;
import com.conurets.hcm.base.dto.request.UpdateErrorCodeRequestDTO;
import com.conurets.hcm.base.dto.response.ErrorCodeResponseDTO;
import com.conurets.hcm.base.exception.HCMException;
import com.conurets.hcm.base.util.HCMConstants;
import com.conurets.hcm.base.util.HCMHelper;
import com.conurets.hcm.base.util.HCMUtil;
import com.conurets.hcm.persistence.entity.ErrorCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author MSA
 * @version 1.0
 */

@Slf4j
@Component
public class ErrorCodeMapper extends BaseMapper {
    /**
     *
     * @param model
     * @return
     * @throws HCMException
     */
    public ErrorCode add(AddErrorCodeRequestDTO model) throws HCMException {
        ErrorCode errorCode = new ErrorCode();
        errorCode.setStatus(model.getStatus());

        addAuditingInformation(errorCode);

        return errorCode;
    }

    /**
     *
     * @param model
     * @return
     * @throws HCMException
     */
    public ErrorCode update(UpdateErrorCodeRequestDTO model) throws HCMException {
        ErrorCode errorCode = getDaoFactory().getErrorCodeDAO().findById(model.getErrorCodeId());

        if (errorCode == null) {
            HCMHelper.handleResultNotFound(101, "No result found");
        }

        errorCode.setStatus(model.getStatus());

        addAuditingInformation(errorCode);

        return errorCode;
    }

    /**
     *
     * @param id
     * @return
     * @throws HCMException
     */
    public ErrorCode delete(long id) throws HCMException {
        ErrorCode errorCode = getDaoFactory().getErrorCodeDAO().findById(id);

        if (errorCode == null) {
            HCMHelper.handleResultNotFound(101, "No result found");
        }

        errorCode.setStatus(HCMConstants.Common.STATUS_CODE_DELETE);

        addAuditingInformation(errorCode);

        return errorCode;
    }

    /**
     *
     * @param user
     * @return
     * @throws HCMException
     */
    public ErrorCodeResponseDTO find(ErrorCode user) throws HCMException {
        ErrorCodeResponseDTO errorCodeResponseDTO = new ErrorCodeResponseDTO();
        errorCodeResponseDTO.setStatus(HCMUtil.getStatus(user.getStatus()));

        return errorCodeResponseDTO;
    }
}