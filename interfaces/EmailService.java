public interface EmailService {

    /**
     * save a text file to represent email of weekly report
     * @param
     * @return true: success false: failed
     */
    public boolean weeklyReport();

    /**
     * SMS or Email to the user when he/she registers
     * @param user the new registered user
     * @return true: success false: failed
     */
    public boolean registerReply(User user);
}
