/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package golddigger.abstracts;

import golddigger.mapobjects.Coordinate;
import java.util.Objects;
import javax.swing.ImageIcon;

/**
 *
 * @author alexkurocha
 */
public abstract class AbsGameObject implements IntStaticObject {
    private EnGameObjectType type;
    private Coordinate coordinate;
    private ImageIcon imageIcon;

    @Override
    public ImageIcon getIcon() {
        return imageIcon;
    }

    @Override
    public Coordinate getCoordinate() {
        return coordinate;
    }

    @Override
    public EnGameObjectType getType() {
        return type;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public void setImageIcon(ImageIcon imageIcon) {
        this.imageIcon = imageIcon;
    }

    public void setType(EnGameObjectType type) {
        this.type = type;
    }
    
    // utility for each child class to get icon as ImageIcon object and then
    // set it up to this icon field or to one of moving objects fields
    // for icons (appropriate to direction)
        protected ImageIcon getImageIcon(String path) {
        return new ImageIcon(getClass().getResource(path));
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.type);
        hash = 97 * hash + Objects.hashCode(this.coordinate);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final AbsGameObject other = (AbsGameObject) obj;
        if (this.type != other.type) {
            return false;
        }
        if (!Objects.equals(this.coordinate, other.coordinate)) {
            return false;
        }
        return true;
    }
        
        
}
