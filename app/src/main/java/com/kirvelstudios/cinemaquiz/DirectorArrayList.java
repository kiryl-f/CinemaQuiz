package com.kirvelstudios.cinemaquiz;

import com.kirvelstudios.cinemaquiz.Directors.Director;
import com.kirvelstudios.cinemaquiz.Directors.EasyLevel.*;
import com.kirvelstudios.cinemaquiz.Directors.HardLevel.*;
import com.kirvelstudios.cinemaquiz.Directors.LastLevel.*;
import com.kirvelstudios.cinemaquiz.Directors.MediumLevel.*;


import java.util.ArrayList;

public class DirectorArrayList {

    private ArrayList <Director> directors;
    int curLevel = 1;

    public DirectorArrayList() {
        directors = new ArrayList<>();
        directors.add(new NolanDirector());
        directors.add(new RichieDirector());
        directors.add(new RScottDirector());
        directors.add(new TarantinoDirector());
        directors.add(new SpielbergDirector());
        directors.add(new KubrikDirector());
        directors.add(new HichkokDirector());
        directors.add(new AllenDirector());
        directors.add(new ScorsceseDirector());
        directors.add(new WesAndersonDirector());
        directors.add(new BessonDirector());
        directors.add(new BayDirector());
        //2 level
        directors.add(new LynchDirector());
        directors.add(new TarkovskyDirector());
        directors.add(new DePalmaDirector());
        directors.add(new AranofskiDirector());
        directors.add(new JohnsonDirector());
        directors.add(new StoneDirector());
        directors.add(new SnyderDirector());
        directors.add(new BalabanovDirector());
        directors.add(new TScottDirector());
        directors.add(new PaulThomasDirector());
        directors.add(new CoppolaDirector());
        directors.add(new BurtonDirector());
        //3 level
        directors.add(new BertolucciDirector());
        directors.add(new EisensteinDirector());
        directors.add(new MotylDirector());
        directors.add(new LumetDirector());
        directors.add(new GrayDirector());
        directors.add(new AlmadovarDirector());
        directors.add(new EastwoodDirector());
        directors.add(new LantimosDirector());
        directors.add(new GaidaiDirector());
        directors.add(new ClooneyDirector());
        directors.add(new SidorovDirector());
        directors.add(new OdiarDirector());
        //4 level
        directors.add(new LautnerDirector());
        directors.add(new FerraraDirector());
        directors.add(new BergmanDirector());
        directors.add(new MichalkovDirector());
        directors.add(new RefnDirector());
        directors.add(new ZemekisDirector());
        directors.add(new VilnevDirector());
        directors.add(new HowardDirector());
        directors.add(new InnarituDirector());
        directors.add(new CuaronDirector());
        directors.add(new KurosavaDirector());
        directors.add(new MangoldDirector());
    }

    public ArrayList <Director> getDirectors() {
        return directors;
    }

    public void setDirectors(ArrayList<Director> directors) {
        this.directors = directors;
    }
}
