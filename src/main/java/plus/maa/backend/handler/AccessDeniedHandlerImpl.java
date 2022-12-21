package plus.maa.backend.handler;

import plus.maa.backend.domain.ResponseResult;
import plus.maa.backend.utils.WebUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author AnselYuki
 */
@Component
public class AccessDeniedHandlerImpl implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException {
        ResponseResult<?> result = new ResponseResult<>(HttpStatus.FORBIDDEN.value(), "权限不足");
        String json = new ObjectMapper().writeValueAsString(result);
        WebUtils.renderString(response, json, 403);
    }
}
