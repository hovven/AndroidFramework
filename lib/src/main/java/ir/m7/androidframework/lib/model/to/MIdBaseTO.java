package ir.m7.androidframework.lib.model.to;

import ir.m7.androidframework.lib.model.dao.MSugarRecord;

/**
 * Created by Milad on 12/11/2015.
 */
public class MIdBaseTO extends MSugarRecord implements IMBaseTO {

    //@IdColumn(primaryKey = true)
    private Long id;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }
}
