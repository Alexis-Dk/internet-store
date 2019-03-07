import angular from 'angular';
import angularAnimate from 'angular-animate';
import ngMaterial from 'angular-material';
import ngMessages from 'angular-messages';
import 'angular-aria';
import angularMaterialTable from 'angular-material-data-table';
import 'material-design-icons';
import 'babel-polyfill';
import 'angular-material/angular-material.css';
import 'angular-material-data-table/dist/md-data-table.min.css'
import 'material-design-icons';

angular.module('customMenu', [
    angularAnimate,
    ngMaterial,
    ngMessages,
    angularMaterialTable
]);

// Controllers
var controllers = require.context('./controllers', true, /.js$/);
controllers.keys().forEach(controllers);