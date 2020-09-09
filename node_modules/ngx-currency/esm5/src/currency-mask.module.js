import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { CurrencyMaskDirective } from "./currency-mask.directive";
import { CURRENCY_MASK_CONFIG } from "./currency-mask.config";
var NgxCurrencyModule = /** @class */ (function () {
    function NgxCurrencyModule() {
    }
    NgxCurrencyModule.forRoot = function (config) {
        return {
            ngModule: NgxCurrencyModule,
            providers: [{
                    provide: CURRENCY_MASK_CONFIG,
                    useValue: config,
                }]
        };
    };
    NgxCurrencyModule.decorators = [
        { type: NgModule, args: [{
                    imports: [CommonModule, FormsModule],
                    declarations: [CurrencyMaskDirective],
                    exports: [CurrencyMaskDirective]
                },] }
    ];
    return NgxCurrencyModule;
}());
export { NgxCurrencyModule };
//# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJmaWxlIjoiY3VycmVuY3ktbWFzay5tb2R1bGUuanMiLCJzb3VyY2VSb290Ijoibmc6Ly9uZ3gtY3VycmVuY3kvIiwic291cmNlcyI6WyJzcmMvY3VycmVuY3ktbWFzay5tb2R1bGUudHMiXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IkFBQUEsT0FBTyxFQUFzQixRQUFRLEVBQUMsTUFBTSxlQUFlLENBQUM7QUFDNUQsT0FBTyxFQUFDLFlBQVksRUFBQyxNQUFNLGlCQUFpQixDQUFDO0FBQzdDLE9BQU8sRUFBQyxXQUFXLEVBQUMsTUFBTSxnQkFBZ0IsQ0FBQztBQUMzQyxPQUFPLEVBQUMscUJBQXFCLEVBQUMsTUFBTSwyQkFBMkIsQ0FBQztBQUNoRSxPQUFPLEVBQUMsb0JBQW9CLEVBQXFCLE1BQU0sd0JBQXdCLENBQUM7QUFFaEY7SUFBQTtJQWVBLENBQUM7SUFUUSx5QkFBTyxHQUFkLFVBQWUsTUFBMEI7UUFDdkMsT0FBTztZQUNMLFFBQVEsRUFBRSxpQkFBaUI7WUFDM0IsU0FBUyxFQUFFLENBQUM7b0JBQ1YsT0FBTyxFQUFFLG9CQUFvQjtvQkFDN0IsUUFBUSxFQUFFLE1BQU07aUJBQ2pCLENBQUM7U0FDSCxDQUFBO0lBQ0gsQ0FBQzs7Z0JBZEYsUUFBUSxTQUFDO29CQUNSLE9BQU8sRUFBRSxDQUFFLFlBQVksRUFBRSxXQUFXLENBQUU7b0JBQ3RDLFlBQVksRUFBRSxDQUFFLHFCQUFxQixDQUFFO29CQUN2QyxPQUFPLEVBQUUsQ0FBRSxxQkFBcUIsQ0FBRTtpQkFDbkM7O0lBV0Qsd0JBQUM7Q0FBQSxBQWZELElBZUM7U0FWWSxpQkFBaUIiLCJzb3VyY2VzQ29udGVudCI6WyJpbXBvcnQge01vZHVsZVdpdGhQcm92aWRlcnMsIE5nTW9kdWxlfSBmcm9tICdAYW5ndWxhci9jb3JlJztcbmltcG9ydCB7Q29tbW9uTW9kdWxlfSBmcm9tICdAYW5ndWxhci9jb21tb24nO1xuaW1wb3J0IHtGb3Jtc01vZHVsZX0gZnJvbSAnQGFuZ3VsYXIvZm9ybXMnO1xuaW1wb3J0IHtDdXJyZW5jeU1hc2tEaXJlY3RpdmV9IGZyb20gXCIuL2N1cnJlbmN5LW1hc2suZGlyZWN0aXZlXCI7XG5pbXBvcnQge0NVUlJFTkNZX01BU0tfQ09ORklHLCBDdXJyZW5jeU1hc2tDb25maWd9IGZyb20gXCIuL2N1cnJlbmN5LW1hc2suY29uZmlnXCI7XG5cbkBOZ01vZHVsZSh7XG4gIGltcG9ydHM6IFsgQ29tbW9uTW9kdWxlLCBGb3Jtc01vZHVsZSBdLFxuICBkZWNsYXJhdGlvbnM6IFsgQ3VycmVuY3lNYXNrRGlyZWN0aXZlIF0sXG4gIGV4cG9ydHM6IFsgQ3VycmVuY3lNYXNrRGlyZWN0aXZlIF1cbn0pXG5leHBvcnQgY2xhc3MgTmd4Q3VycmVuY3lNb2R1bGUge1xuICBzdGF0aWMgZm9yUm9vdChjb25maWc6IEN1cnJlbmN5TWFza0NvbmZpZyk6IE1vZHVsZVdpdGhQcm92aWRlcnM8Tmd4Q3VycmVuY3lNb2R1bGU+IHtcbiAgICByZXR1cm4ge1xuICAgICAgbmdNb2R1bGU6IE5neEN1cnJlbmN5TW9kdWxlLFxuICAgICAgcHJvdmlkZXJzOiBbe1xuICAgICAgICBwcm92aWRlOiBDVVJSRU5DWV9NQVNLX0NPTkZJRyxcbiAgICAgICAgdXNlVmFsdWU6IGNvbmZpZyxcbiAgICAgIH1dXG4gICAgfVxuICB9XG59XG4iXX0=