/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package golddigger.users;

/**
 *
 * @author alexkurocha
 */
public class AbsUserManager implements IntUserManager {
    
    protected UserScore user = new UserScore();

    public UserScore getUser() {
        return user;
    }

    public void setUser(UserScore user) {
        this.user = user;
    }
    
    public void createNewUser(String userName) {
        user = new UserScore(userName);
    }
        
    @Override
    public void save() {
        
    }
    
}
