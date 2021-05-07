package hr.tvz.android.fragmentifilip.model;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;

@Table(database = BazaPodataka.class)
public class Cars {

    @Column
    @PrimaryKey(autoincrement = true)
    int id;

    @Column
    String name;

    @Column
    String image;

    @Column
    String url;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String image) {
        this.url = url;
    }

}
