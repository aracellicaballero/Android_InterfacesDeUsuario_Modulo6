package adaptador;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import fragment.BasicFragment;
import com.nextu.sacc.evaluacionfinal_modulo6.R;

/**
 * Created by Sara Caballero C on 2017/11/01.
 */

public class BaseViewPagerAdapter extends FragmentStatePagerAdapter {

    private String[] tabs;

    public BaseViewPagerAdapter(FragmentManager manager, Context context, int idItem) {
        super(manager);

        switch (idItem){
            case R.id.nav_facebook:
                tabs = context.getResources().getStringArray(R.array.tabs_facebook);
                break;
            case R.id.nav_instagram:
                tabs = context.getResources().getStringArray(R.array.tabs_instagram);
                break;
            case R.id.nav_googleplus:
                tabs = context.getResources().getStringArray(R.array.tabs_googleplus);
                break;
            case R.id.nav_twitter:
                tabs = context.getResources().getStringArray(R.array.tabs_twitter);
                break;
            default:
                tabs = context.getResources().getStringArray(R.array.tabs_facebook);
                break;
        }
    }

    @Override
    public Fragment getItem(int position) {
        return BasicFragment.getInstance(tabs[position], position);
    }

    @Override
    public int getCount() {
        return tabs.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabs[position];
    }

}
