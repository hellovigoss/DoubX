package api;

import args.HelloArgs;

/**
 * Created by yedai on 15-1-14.
 */
public class Hello extends Api {

    @Override
    protected String work() {
        HelloArgs args = (HelloArgs)this.args;

        return args.name + " says: " + args.words;
    }
}
