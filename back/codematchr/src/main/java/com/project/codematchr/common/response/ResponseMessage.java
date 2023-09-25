package com.project.codematchr.common.response;

public interface ResponseMessage {
    String SUCCESS = "Success";
    
    String SIGN_IN_FAIL = "Sign In Fail";
    String REQUEST_PARAMETER_VALIDATION_FAILED = "Request Parameter Validation Failed";
    String AUTHENTICATION_FAIL = "Authentication Fail";

    String EXISTED_USER_EMAIL = "Existed User email";
    String EXISTED_USER_NICKNAME = "Existed User nickname";
    String EXISTED_USER_TELNUMBER = "Existed User telnumber";

    String NO_EXSITED_USER_EMAIL = "No Exsited User Email";
    String NO_EXISTED_BOARD_NUMBER = "No Existed Board Number";
    String NO_EXISTED_COMPARE_RESULT_NUMBER = "No Existed Compare Result Number";
    String NO_EXISTED_COMPARE_RESULT = "No Existed Compare Result";
    String NO_EXISTED_MULTI_ROOM_NUMBER = "No Existed Multi room Number";


    String EXISTED_ROOM_TITLE_SUBJECT = "Existed Room Title Subject";

    String PASSWORD_CHANGE_FAIL = "Password Change Fail";

    String NO_PORMISSION = "No Permission";

    String DATABASE_ERROR = "Database Error";
}
