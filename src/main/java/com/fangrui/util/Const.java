package com.fangrui.util;

/**
 * @author zhangfangrui
 * @description
 * @date 2018/5/22
 */
public class Const {
    /**
     * 资源类型
     */
    public enum ResourceType {
        /**
         * 游戏类型
         */
        GAME_TYPE {
            @Override
            public Integer getValue() {
                return 0;
            }

            @Override
            public String getName() {
                return "游戏";
            }
        },
        MOVIE_TYPE {
            @Override
            public Integer getValue() {
                return 1;
            }

            @Override
            public String getName() {
                return "视频";
            }
        },
        TELEVISION_TYPE {
            @Override
            public Integer getValue() {
                return 2;
            }

            @Override
            public String getName() {
                return "电视剧";
            }
        },
        SOFTWARE_TYPE {
            @Override
            public Integer getValue() {
                return 3;
            }

            @Override
            public String getName() {
                return "软件";
            }
        };

        public abstract Integer getValue();

        public abstract String getName();
    }
}
