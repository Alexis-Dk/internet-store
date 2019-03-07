/**
 * Created by Alex D.
 */

const webpack = require('webpack');
const CleanWebpackPlugin = require('clean-webpack-plugin');

module.exports = {
    context: __dirname,
    entry: {
        customMenu: './'
    },
    output: {
        path: __dirname + '/webapp/resources',
        filename: 'js/[name].js'
    },

    // devtool: 'eval',

    plugins: [
        new webpack.NoErrorsPlugin(),

        new CleanWebpackPlugin(['../webapp/resources/js']),

        new webpack.optimize.UglifyJsPlugin({
            compress: {
                warnings: false
            }
        })
    ],

    module: {
        loaders: [{
            test: /\.js$/,
            exclude: /\/node_modules\/|\/bower_components\//,
            loader: 'ng-annotate!babel'
        }, {
            test: /\.html$/,
            loader: 'html'
        }, {
            test: /\.css$/,
            loader: 'style!css'
        }, {
            test: /\.(png|jpg|svg|ttf|eof|eot|woff|woff2|gif)$/,
            loader: 'file?name=/images/[name].[hash].[ext]?[hash]'
        }],

        noParse: /angular\/angular.js/
    }
};

