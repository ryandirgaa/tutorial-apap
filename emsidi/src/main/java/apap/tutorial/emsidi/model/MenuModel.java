package apap.tutorial.emsidi.model;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter @Getter
@Entity
@Table(name = "menu")

public class MenuModel implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long noMenu;

    @NotNull
    @Size(max=30)
    @Column(name = "nama_menu", nullable = false)
    private String namaMenu;

    @NotNull
    @Size(max=100)
    @Column(name = "deskripsi_menu", nullable = false)
    private String deskripsiMenu;

    @Column(name = "is_available", nullable = false)
    private Boolean isAvailable;

    //Relasi dengan CabangModel
    @ManyToMany(mappedBy = "listMenu")
    List<CabangModel> listCabang;
}
