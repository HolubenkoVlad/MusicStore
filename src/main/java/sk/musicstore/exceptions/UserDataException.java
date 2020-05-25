package sk.musicstore.exceptions;

/**
 * Own exception that will be raised when the user does not enter a login during authorization.
 * */

public class UserDataException extends Exception {
    public UserDataException(String message){
        super(message);
    }
}
