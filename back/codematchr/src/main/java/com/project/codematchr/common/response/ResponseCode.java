package com.project.codematchr.common.response;

public interface ResponseCode {
    String SUCCESS = "SU";

    String SIGN_IN_FAIL = "SF";
    String REQUEST_PARAMETER_VALIDATION_FAILED = "RF";
    String AUTHENTICATION_FAIL = "AF";

    String EXISTED_USER_EMAIL = "EE";
    String EXISTED_USER_NICKNAME = "EN";
    String EXISTED_USER_TELNUMBER = "ET";

    String NO_EXSITED_USER_EMAIL = "NE";
    String NO_EXISTED_BOARD_NUMBER = "NN";
    String NO_EXISTED_COMPARE_RESULT_NUMBER = "NC";
    String NO_EXISTED_COMPARE_RESULT = "NR";
    String NO_EXISTED_MULTI_ROOM_NUMBER = "NM";


    String EXSITED_ROOM_TITLE_SUBJECT = "ES";

    String PASSWORD_CHANGE_FAIL = "PF";

    String NO_PORMISSION = "NP";

    String DATABASE_ERROR = "DE";
}
