
package entity;

public class Orders{
    private String datatime; // create date 
    private Integer idOreder; // db id
    private String NomerOrder; 
    private int cost;
    private Integer idUser;
    private Integer idFirm;
    private Users Custom;
    private Firms Executor;

    public Orders() {
    }

    public Orders(Integer idOreder) {
        this.idOreder = idOreder;
    }

    public Orders(Integer idOreder, String datatime, int cost) {
        this.idOreder = idOreder;
        this.datatime = datatime;
        this.cost = cost;
    }
    
     public Orders(Integer idUser,Integer idFirm, String datatime, int cost) {
        this.idUser=idUser;
        this.idFirm=idFirm;
        this.datatime = datatime;
        this.cost = cost;
    }
     
    public void SetUser(Users Custom) {
        this.Custom = Custom;
    }
    public void setFirm(Firms Executor) {
        this.Executor = Executor;
    }
    
    public Users GetUserdata() {
      return Custom;
    }
 
    public Firms GetFirmdata() {
      return Executor;
    }

    public Integer getIdOreder() {
        return idOreder;
    }

    public void setIdOreder(Integer idOreder) {
        this.idOreder = idOreder;
    }

    public String getDatatime() {
        return datatime;
    }

    public void setDatatime(String datatime) {
        this.datatime = datatime;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public Integer getIdFirm() {
        return idFirm;
    }

    public void setIdFirm(Integer idFirm) {
        this.idFirm = idFirm;
    }

    public void setUserData(Users User) {
       this.Custom=User;
    }

}
