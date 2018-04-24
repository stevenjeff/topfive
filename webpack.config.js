var webpack = require('webpack');
module.exports = {
    //2、进出口文件配置
    entry: __dirname + '/source/js/index.js',//指定的入口文件,“__dirname”是node.js中的一个全局变量，它指向当前执行脚本所在的目录
    output: {//输出
        path: __dirname + '/build',//输出路径
        filename: 'bundle.js'//输出文件名
    },
    module: {//在配置文件里添加加载器说明，指明每种文件需要什么加载器处理
        rules: [
            {
                use: 'babel-loader',
                test: /\.js$/
            },
            {//json加载器
                test: /\.json$/,
                loader: "json-loader"//注意-loader不能省略，网上说能省略，经测试编译会报错
            },
            {//5、编译es6配置
                test: /\.js$/,
                exclude: /node_modules/,
                loader: 'babel-loader',//在webpack的module部分的loaders里进行配置即可
                query: {
                    presets: ['es2015']
                }
            },
            {//3、CSS-loader
                test: /\.css$/,
                loader: 'style-loader!css-loader'//添加对样式表的处理
            }

        ]
    },
    //4、服务器依赖包配置
    devServer: {//注意：网上很多都有colors属性，但是实际上的webpack2.x已经不支持该属性了
        contentBase: "./source",//本地服务器所加载的页面所在的目录
        historyApiFallback: true,//不跳转
        inline: true//实时刷新
        //hot：true,//不要书写该属性，否则浏览器无法自动更新
        //publicPath："/asses/",//设置该属性后，webpack-dev-server会相对于该路径
    },
    plugins: []//插件
}