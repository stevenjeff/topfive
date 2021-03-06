const webpack = require('webpack');
const path = require('path');
const ExtractTextWebpackPlugin = require('extract-text-webpack-plugin');
const extractCss = new ExtractTextWebpackPlugin("css/[name].css");
const HtmlWebpackPlugin = require('html-webpack-plugin');
const dir = "D:/intelijworkspace/topfive";
module.exports = {
    //2、进出口文件配置
    entry: {
        index: path.resolve(__dirname + '/source/index.js')
    },
    output: {//输出
        path: __dirname + '/build',//输出路径
        filename: '[name].[hash:8].js',//输出文件名
        chunkFilename: '[name].[hash:8].js'
    },
    module: {//在配置文件里添加加载器说明，指明每种文件需要什么加载器处理
        rules: [
            {
                test: /\.vue$/,
                loader: 'vue-loader',
                options: {
                    // vue-loader options go here
                }
            },
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
                exclude: [
                    path.join(__dirname, '/node_modules'),
                    path.join(__dirname, '/source/js/')
                ],
                loader: 'babel-loader',//在webpack的module部分的loaders里进行配置即可
                query: {
                    presets: ['es2015']
                }
            },
            {//3、CSS-loader
                test: /\.css$/,
                loader: 'style-loader!css-loader'//添加对样式表的处理
            },
            {
                test: /\.(png|jpg|gif|svg)$/,
                loader: 'file',
                options: {
                    name: '[name].[ext]?[hash]'
                }
            },
            {
                test: /\.less$/,
                loaders: 'style-loader!css-loader!less-loader'
            },
            {
                test: /\.scss$/,
                loaders: 'style-loader!css-loader!sass-loader'
            },
            {
                test: /\.(png|jpg|jpeg|gif|eot|ttf|woff|woff2|svg|svgz)(\?.+)?$/,
                use: [{
                    loader: 'url-loader',
                    options: {
                        limit: 10000
                    }
                }]
            }
        ]
    },
    //其他解决方案配置
    resolve: {
        extensions: ['.js', '.json', '.css', '.scss', '.vue']//添加在此的后缀所对应的文件可以省略后缀
    },
    //4、服务器依赖包配置
    devServer: {//注意：网上很多都有colors属性，但是实际上的webpack2.x已经不支持该属性了
        contentBase: "./source",//本地服务器所加载的页面所在的目录
        historyApiFallback: true,//不跳转
        inline: true,//实时刷新
        port: 8181
        //hot：true,//不要书写该属性，否则浏览器无法自动更新
        //publicPath："/asses/",//设置该属性后，webpack-dev-server会相对于该路径
    },
    performance: {
        hints: false
    },
    plugins: [
        new webpack.ProvidePlugin({
            $: "jquery",
            jQuery: "jquery",
            "window.jQuery": "jquery"
        }),
        new HtmlWebpackPlugin({
            title: 'top resource',
            template: __dirname + '/build/index.html',
            hash: true
        })
    ]//插件
}
if (process.env.NODE_ENV === 'production') {
    module.exports.devtool = '#source-map'
    // http://vue-loader.vuejs.org/en/workflow/production.html
    module.exports.plugins = (module.exports.plugins || []).concat([
        new webpack.DefinePlugin({
            'process.env': {
                NODE_ENV: '"production"'
            }
        }),
        new webpack.optimize.UglifyJsPlugin({
            compress: {
                warnings: false
            },
            mangle: {
                except: ['$super', '$', 'exports', 'require']
            }
        }),
        new webpack.LoaderOptionsPlugin({
            minimize: true
        })
    ])
}