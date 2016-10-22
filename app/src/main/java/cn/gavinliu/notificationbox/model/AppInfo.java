package cn.gavinliu.notificationbox.model;

import android.graphics.drawable.Drawable;

import com.litesuits.orm.db.annotation.Column;
import com.litesuits.orm.db.annotation.Ignore;
import com.litesuits.orm.db.annotation.NotNull;
import com.litesuits.orm.db.annotation.PrimaryKey;
import com.litesuits.orm.db.annotation.Table;
import com.litesuits.orm.db.enums.AssignType;

/**
 * Created by Gavin on 2016/10/11.
 */
@Table("apps")
public class AppInfo {

    @PrimaryKey(AssignType.AUTO_INCREMENT)
    @Column("_id")
    private int id;

    @NotNull
    private String packageName;

    @NotNull
    private String appName;

    @Ignore
    private Drawable icon;

    @Ignore
    private boolean isSelect;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public Drawable getIcon() {
        return icon;
    }

    public void setIcon(Drawable icon) {
        this.icon = icon;
    }

    public boolean isSelect() {
        return isSelect;
    }

    public void setSelect(boolean select) {
        isSelect = select;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof AppInfo) {
            AppInfo o = (AppInfo) obj;
            if (o.getPackageName().equals(packageName)) {
                return true;
            } else {
                return false;
            }
        }

        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode() + packageName.hashCode();
    }
}
