import { AfterViewInit, Directive, DoCheck, ElementRef, forwardRef, HostListener, Inject, KeyValueDiffer, KeyValueDiffers, Input, OnInit, Optional } from "@angular/core";
import { NG_VALUE_ACCESSOR } from "@angular/forms";
import { CURRENCY_MASK_CONFIG, CurrencyMaskInputMode } from "./currency-mask.config";
import { InputHandler } from "./input.handler";
export var CURRENCYMASKDIRECTIVE_VALUE_ACCESSOR = {
    provide: NG_VALUE_ACCESSOR,
    useExisting: forwardRef(function () { return CurrencyMaskDirective; }),
    multi: true,
};
var CurrencyMaskDirective = /** @class */ (function () {
    function CurrencyMaskDirective(currencyMaskConfig, elementRef, keyValueDiffers) {
        this.currencyMaskConfig = currencyMaskConfig;
        this.elementRef = elementRef;
        this.keyValueDiffers = keyValueDiffers;
        this.options = {};
        this.optionsTemplate = {
            align: "right",
            allowNegative: true,
            allowZero: true,
            decimal: ".",
            precision: 2,
            prefix: "$ ",
            suffix: "",
            thousands: ",",
            nullable: false,
            inputMode: CurrencyMaskInputMode.FINANCIAL
        };
        if (currencyMaskConfig) {
            this.optionsTemplate = currencyMaskConfig;
        }
        this.keyValueDiffer = keyValueDiffers.find({}).create();
    }
    CurrencyMaskDirective.prototype.ngAfterViewInit = function () {
        this.elementRef.nativeElement.style.textAlign = this.options && this.options.align ? this.options.align : this.optionsTemplate.align;
    };
    CurrencyMaskDirective.prototype.ngDoCheck = function () {
        if (this.keyValueDiffer.diff(this.options)) {
            this.elementRef.nativeElement.style.textAlign = this.options.align ? this.options.align : this.optionsTemplate.align;
            this.inputHandler.updateOptions(Object.assign({}, this.optionsTemplate, this.options));
        }
    };
    CurrencyMaskDirective.prototype.ngOnInit = function () {
        this.inputHandler = new InputHandler(this.elementRef.nativeElement, Object.assign({}, this.optionsTemplate, this.options));
    };
    CurrencyMaskDirective.prototype.handleBlur = function (event) {
        this.inputHandler.getOnModelTouched().apply(event);
    };
    CurrencyMaskDirective.prototype.handleCut = function (event) {
        if (!this.isChromeAndroid()) {
            !this.isReadOnly() && this.inputHandler.handleCut(event);
        }
    };
    CurrencyMaskDirective.prototype.handleInput = function (event) {
        if (this.isChromeAndroid()) {
            !this.isReadOnly() && this.inputHandler.handleInput(event);
        }
    };
    CurrencyMaskDirective.prototype.handleKeydown = function (event) {
        if (!this.isChromeAndroid()) {
            !this.isReadOnly() && this.inputHandler.handleKeydown(event);
        }
    };
    CurrencyMaskDirective.prototype.handleKeypress = function (event) {
        if (!this.isChromeAndroid()) {
            !this.isReadOnly() && this.inputHandler.handleKeypress(event);
        }
    };
    CurrencyMaskDirective.prototype.handlePaste = function (event) {
        if (!this.isChromeAndroid()) {
            !this.isReadOnly() && this.inputHandler.handlePaste(event);
        }
    };
    CurrencyMaskDirective.prototype.handleDrop = function (event) {
        if (!this.isChromeAndroid()) {
            event.preventDefault();
        }
    };
    CurrencyMaskDirective.prototype.isChromeAndroid = function () {
        return /chrome/i.test(navigator.userAgent) && /android/i.test(navigator.userAgent);
    };
    CurrencyMaskDirective.prototype.isReadOnly = function () {
        return this.elementRef.nativeElement.hasAttribute('readonly');
    };
    CurrencyMaskDirective.prototype.registerOnChange = function (callbackFunction) {
        this.inputHandler.setOnModelChange(callbackFunction);
    };
    CurrencyMaskDirective.prototype.registerOnTouched = function (callbackFunction) {
        this.inputHandler.setOnModelTouched(callbackFunction);
    };
    CurrencyMaskDirective.prototype.setDisabledState = function (value) {
        this.elementRef.nativeElement.disabled = value;
    };
    CurrencyMaskDirective.prototype.writeValue = function (value) {
        this.inputHandler.setValue(value);
    };
    CurrencyMaskDirective.ctorParameters = function () { return [
        { type: undefined, decorators: [{ type: Optional }, { type: Inject, args: [CURRENCY_MASK_CONFIG,] }] },
        { type: ElementRef },
        { type: KeyValueDiffers }
    ]; };
    CurrencyMaskDirective.decorators = [
        { type: Directive, args: [{
                    selector: "[currencyMask]",
                    providers: [CURRENCYMASKDIRECTIVE_VALUE_ACCESSOR]
                },] }
    ];
    CurrencyMaskDirective.ctorParameters = function () { return [
        { type: undefined, decorators: [{ type: Optional }, { type: Inject, args: [CURRENCY_MASK_CONFIG,] }] },
        { type: ElementRef },
        { type: KeyValueDiffers }
    ]; };
    CurrencyMaskDirective.propDecorators = {
        options: [{ type: Input }],
        handleBlur: [{ type: HostListener, args: ["blur", ["$event"],] }],
        handleCut: [{ type: HostListener, args: ["cut", ["$event"],] }],
        handleInput: [{ type: HostListener, args: ["input", ["$event"],] }],
        handleKeydown: [{ type: HostListener, args: ["keydown", ["$event"],] }],
        handleKeypress: [{ type: HostListener, args: ["keypress", ["$event"],] }],
        handlePaste: [{ type: HostListener, args: ["paste", ["$event"],] }],
        handleDrop: [{ type: HostListener, args: ["drop", ["$event"],] }]
    };
    return CurrencyMaskDirective;
}());
export { CurrencyMaskDirective };
//# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJmaWxlIjoiY3VycmVuY3ktbWFzay5kaXJlY3RpdmUuanMiLCJzb3VyY2VSb290Ijoibmc6Ly9uZ3gtY3VycmVuY3kvIiwic291cmNlcyI6WyJzcmMvY3VycmVuY3ktbWFzay5kaXJlY3RpdmUudHMiXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IkFBQUEsT0FBTyxFQUNMLGFBQWEsRUFDYixTQUFTLEVBQ1QsT0FBTyxFQUNQLFVBQVUsRUFDVixVQUFVLEVBQ1YsWUFBWSxFQUNaLE1BQU0sRUFDTixjQUFjLEVBQ2QsZUFBZSxFQUNmLEtBQUssRUFDTCxNQUFNLEVBQ04sUUFBUSxFQUNULE1BQU0sZUFBZSxDQUFDO0FBRXZCLE9BQU8sRUFBdUIsaUJBQWlCLEVBQUMsTUFBTSxnQkFBZ0IsQ0FBQztBQUN2RSxPQUFPLEVBQXFCLG9CQUFvQixFQUFFLHFCQUFxQixFQUFDLE1BQU0sd0JBQXdCLENBQUM7QUFDdkcsT0FBTyxFQUFDLFlBQVksRUFBQyxNQUFNLGlCQUFpQixDQUFDO0FBRTdDLE1BQU0sQ0FBQyxJQUFNLG9DQUFvQyxHQUFRO0lBQ3ZELE9BQU8sRUFBRSxpQkFBaUI7SUFDMUIsV0FBVyxFQUFFLFVBQVUsQ0FBQyxjQUFNLE9BQUEscUJBQXFCLEVBQXJCLENBQXFCLENBQUM7SUFDcEQsS0FBSyxFQUFFLElBQUk7Q0FDWixDQUFDO0FBRUY7SUF3QkUsK0JBQThELGtCQUFzQyxFQUN0QyxVQUFzQixFQUN0QixlQUFnQztRQUZoQyx1QkFBa0IsR0FBbEIsa0JBQWtCLENBQW9CO1FBQ3RDLGVBQVUsR0FBVixVQUFVLENBQVk7UUFDdEIsb0JBQWUsR0FBZixlQUFlLENBQWlCO1FBcEJyRixZQUFPLEdBQWdDLEVBQUUsQ0FBQztRQUs1QyxvQkFBZSxHQUF1QjtZQUN6QyxLQUFLLEVBQUUsT0FBTztZQUNkLGFBQWEsRUFBRSxJQUFJO1lBQ25CLFNBQVMsRUFBRSxJQUFJO1lBQ2YsT0FBTyxFQUFFLEdBQUc7WUFDWixTQUFTLEVBQUUsQ0FBQztZQUNaLE1BQU0sRUFBRSxJQUFJO1lB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QkFDTCxlQUFlOzs7Z0JBMUIvRixTQUFTLFNBQUM7b0JBQ1AsUUFBUSxFQUFFLGdCQUFnQjtvQkFDMUIsU0FBUyxFQUFFLENBQUMsb0NBQW9DLENBQUM7aUJBQ3BEOzs7Z0RBcUJjLFFBQVEsWUFBSSxNQUFNLFNBQUMsb0JBQW9CO2dCQTdDcEQsVUFBVTtnQkFLVixlQUFlOzs7MEJBc0JkLEtBQUs7NkJBMkNMLFlBQVksU0FBQyxNQUFNLEVBQUUsQ0FBQyxRQUFRLENBQUM7NEJBSy9CLFlBQVksU0FBQyxLQUFLLEVBQUUsQ0FBQyxRQUFRLENBQUM7OEJBTzlCLFlBQVksU0FBQyxPQUFPLEVBQUUsQ0FBQyxRQUFRLENBQUM7Z0NBT2hDLFlBQVksU0FBQyxTQUFTLEVBQUUsQ0FBQyxRQUFRLENBQUM7aUNBT2xDLFlBQVksU0FBQyxVQUFVLEVBQUUsQ0FBQyxRQUFRLENBQUM7OEJBT25DLFlBQVksU0FBQyxPQUFPLEVBQUUsQ0FBQyxRQUFRLENBQUM7NkJBT2hDLFlBQVksU0FBQyxNQUFNLEVBQUUsQ0FBQyxRQUFRLENBQUM7O0lBOEJsQyw0QkFBQztDQUFBLEFBdkhELElBdUhDO1NBbkhZLHFCQUFxQiIsInNvdXJjZXNDb250ZW50IjpbImltcG9ydCB7XG4gIEFmdGVyVmlld0luaXQsXG4gIERpcmVjdGl2ZSxcbiAgRG9DaGVjayxcbiAgRWxlbWVudFJlZixcbiAgZm9yd2FyZFJlZixcbiAgSG9zdExpc3RlbmVyLFxuICBJbmplY3QsXG4gIEtleVZhbHVlRGlmZmVyLFxuICBLZXlWYWx1ZURpZmZlcnMsXG4gIElucHV0LFxuICBPbkluaXQsXG4gIE9wdGlvbmFsXG59IGZyb20gXCJAYW5ndWxhci9jb3JlXCI7XG5cbmltcG9ydCB7Q29udHJvbFZhbHVlQWNjZXNzb3IsIE5HX1ZBTFVFX0FDQ0VTU09SfSBmcm9tIFwiQGFuZ3VsYXIvZm9ybXNcIjtcbmltcG9ydCB7Q3VycmVuY3lNYXNrQ29uZmlnLCBDVVJSRU5DWV9NQVNLX0NPTkZJRywgQ3VycmVuY3lNYXNrSW5wdXRNb2RlfSBmcm9tIFwiLi9jdXJyZW5jeS1tYXNrLmNvbmZpZ1wiO1xuaW1wb3J0IHtJbnB1dEhhbmRsZXJ9IGZyb20gXCIuL2lucHV0LmhhbmRsZXJcIjtcblxuZXhwb3J0IGNvbnN0IENVUlJFTkNZTUFTS0RJUkVDVElWRV9WQUxVRV9BQ0NFU1NPUjogYW55ID0ge1xuICBwcm92aWRlOiBOR19WQUxVRV9BQ0NFU1NPUixcbiAgdXNlRXhpc3Rpbmc6IGZvcndhcmRSZWYoKCkgPT4gQ3VycmVuY3lNYXNrRGlyZWN0aXZlKSxcbiAgbXVsdGk6IHRydWUsXG59O1xuXG5ARGlyZWN0aXZlKHtcbiAgICBzZWxlY3RvcjogXCJbY3VycmVuY3lNYXNrXVwiLFxuICAgIHByb3ZpZGVyczogW0NVUlJFTkNZTUFTS0RJUkVDVElWRV9WQUxVRV9BQ0NFU1NPUl1cbn0pXG5leHBvcnQgY2xhc3MgQ3VycmVuY3lNYXNrRGlyZWN0aXZlIGltcGxlbWVudHMgQWZ0ZXJWaWV3SW5pdCwgQ29udHJvbFZhbHVlQWNjZXNzb3IsIERvQ2hlY2ssIE9uSW5pdCB7XG5cbiAgQElucHV0KCkgb3B0aW9uczogUGFydGlhbDxDdXJyZW5jeU1hc2tDb25maWc+ID0ge307XG5cbiAgcHVibGljIGlucHV0SGFuZGxlcjogSW5wdXRIYW5kbGVyO1xuICBwdWJsaWMga2V5VmFsdWVEaWZmZXI6IEtleVZhbHVlRGlmZmVyPGFueSwgYW55PjtcblxuICBwdWJsaWMgb3B0aW9uc1RlbXBsYXRlOiBDdXJyZW5jeU1hc2tDb25maWcgPSB7XG4gICAgICBhbGlnbjogXCJyaWdodFwiLFxuICAgICAgYWxsb3dOZWdhdGl2ZTogdHJ1ZSxcbiAgICAgIGFsbG93WmVybzogdHJ1ZSxcbiAgICAgIGRlY2ltYWw6IFwiLlwiLFxuICAgICAgcHJlY2lzaW9uOiAyLFxuICAgICAgcHJlZml4OiBcIiQgXCIsXG4gICAgICBzdWZmaXg6IFwiXCIsXG4gICAgICB0aG91c2FuZHM6IFwiLFwiLFxuICAgICAgbnVsbGFibGU6IGZhbHNlLFxuICAgICAgaW5wdXRNb2RlOiBDdXJyZW5jeU1hc2tJbnB1dE1vZGUuRklOQU5DSUFMXG4gIH07XG5cbiAgY29uc3RydWN0b3IoQE9wdGlvbmFsKCkgQEluamVjdChDVVJSRU5DWV9NQVNLX0NPTkZJRykgcHJpdmF0ZSBjdXJyZW5jeU1hc2tDb25maWc6IEN1cnJlbmN5TWFza0NvbmZpZyxcbiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgcHJpdmF0ZSBlbGVtZW50UmVmOiBFbGVtZW50UmVmLFxuICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICBwcml2YXRlIGtleVZhbHVlRGlmZmVyczogS2V5VmFsdWVEaWZmZXJzKSB7XG4gICAgaWYgKGN1cnJlbmN5TWFza0NvbmZpZykge1xuICAgICAgICB0aGlzLm9wdGlvbnNUZW1wbGF0ZSA9IGN1cnJlbmN5TWFza0NvbmZpZztcbiAgICB9XG5cbiAgICB0aGlzLmtleVZhbHVlRGlmZmVyID0ga2V5VmFsdWVEaWZmZXJzLmZpbmQoe30pLmNyZWF0ZSgpO1xuICB9XG5cbiAgbmdBZnRlclZpZXdJbml0KCkge1xuICAgIHRoaXMuZWxlbWVudFJlZi5uYXRpdmVFbGVtZW50LnN0eWxlLnRleHRBbGlnbiA9IHRoaXMub3B0aW9ucyAmJiB0aGlzLm9wdGlvbnMuYWxpZ24gPyB0aGlzLm9wdGlvbnMuYWxpZ24gOiB0aGlzLm9wdGlvbnNUZW1wbGF0ZS5hbGlnbjtcbiAgfVxuXG4gIG5nRG9DaGVjaygpIHtcbiAgICBpZiAodGhpcy5rZXlWYWx1ZURpZmZlci5kaWZmKHRoaXMub3B0aW9ucykpIHtcbiAgICAgIHRoaXMuZWxlbWVudFJlZi5uYXRpdmVFbGVtZW50LnN0eWxlLnRleHRBbGlnbiA9IHRoaXMub3B0aW9ucy5hbGlnbiA/IHRoaXMub3B0aW9ucy5hbGlnbiA6IHRoaXMub3B0aW9uc1RlbXBsYXRlLmFsaWduO1xuICAgICAgdGhpcy5pbnB1dEhhbmRsZXIudXBkYXRlT3B0aW9ucygoPGFueT5PYmplY3QpLmFzc2lnbih7fSwgdGhpcy5vcHRpb25zVGVtcGxhdGUsIHRoaXMub3B0aW9ucykpO1xuICAgIH1cbiAgfVxuXG4gIG5nT25Jbml0KCkge1xuICAgIHRoaXMuaW5wdXRIYW5kbGVyID0gbmV3IElucHV0SGFuZGxlcih0aGlzLmVsZW1lbnRSZWYubmF0aXZlRWxlbWVudCwgKDxhbnk+T2JqZWN0KS5hc3NpZ24oe30sIHRoaXMub3B0aW9uc1RlbXBsYXRlLCB0aGlzLm9wdGlvbnMpKTtcbiAgfVxuXG4gIEBIb3N0TGlzdGVuZXIoXCJibHVyXCIsIFtcIiRldmVudFwiXSlcbiAgaGFuZGxlQmx1cihldmVudDogYW55KSB7XG4gICAgdGhpcy5pbnB1dEhhbmRsZXIuZ2V0T25Nb2RlbFRvdWNoZWQoKS5hcHBseShldmVudCk7XG4gIH1cblxuICBASG9zdExpc3RlbmVyKFwiY3V0XCIsIFtcIiRldmVudFwiXSlcbiAgaGFuZGxlQ3V0KGV2ZW50OiBhbnkpIHtcbiAgICBpZiAoIXRoaXMuaXNDaHJvbWVBbmRyb2lkKCkpIHtcbiAgICAgICF0aGlzLmlzUmVhZE9ubHkoKSAmJiB0aGlzLmlucHV0SGFuZGxlci5oYW5kbGVDdXQoZXZlbnQpO1xuICAgIH1cbiAgfVxuXG4gIEBIb3N0TGlzdGVuZXIoXCJpbnB1dFwiLCBbXCIkZXZlbnRcIl0pXG4gIGhhbmRsZUlucHV0KGV2ZW50OiBhbnkpIHtcbiAgICBpZiAodGhpcy5pc0Nocm9tZUFuZHJvaWQoKSkge1xuICAgICAgIXRoaXMuaXNSZWFkT25seSgpICYmIHRoaXMuaW5wdXRIYW5kbGVyLmhhbmRsZUlucHV0KGV2ZW50KTtcbiAgICB9XG4gIH1cblxuICBASG9zdExpc3RlbmVyKFwia2V5ZG93blwiLCBbXCIkZXZlbnRcIl0pXG4gIGhhbmRsZUtleWRvd24oZXZlbnQ6IGFueSkge1xuICAgIGlmICghdGhpcy5pc0Nocm9tZUFuZHJvaWQoKSkge1xuICAgICAgIXRoaXMuaXNSZWFkT25seSgpICYmIHRoaXMuaW5wdXRIYW5kbGVyLmhhbmRsZUtleWRvd24oZXZlbnQpO1xuICAgIH1cbiAgfVxuXG4gIEBIb3N0TGlzdGVuZXIoXCJrZXlwcmVzc1wiLCBbXCIkZXZlbnRcIl0pXG4gIGhhbmRsZUtleXByZXNzKGV2ZW50OiBhbnkpIHtcbiAgICBpZiAoIXRoaXMuaXNDaHJvbWVBbmRyb2lkKCkpIHtcbiAgICAgICF0aGlzLmlzUmVhZE9ubHkoKSAmJiB0aGlzLmlucHV0SGFuZGxlci5oYW5kbGVLZXlwcmVzcyhldmVudCk7XG4gICAgfVxuICB9XG5cbiAgQEhvc3RMaXN0ZW5lcihcInBhc3RlXCIsIFtcIiRldmVudFwiXSlcbiAgaGFuZGxlUGFzdGUoZXZlbnQ6IGFueSkge1xuICAgIGlmICghdGhpcy5pc0Nocm9tZUFuZHJvaWQoKSkge1xuICAgICAgIXRoaXMuaXNSZWFkT25seSgpICYmIHRoaXMuaW5wdXRIYW5kbGVyLmhhbmRsZVBhc3RlKGV2ZW50KTtcbiAgICB9XG4gIH1cblxuICBASG9zdExpc3RlbmVyKFwiZHJvcFwiLCBbXCIkZXZlbnRcIl0pXG4gIGhhbmRsZURyb3AoZXZlbnQ6IGFueSkge1xuICAgIGlmICghdGhpcy5pc0Nocm9tZUFuZHJvaWQoKSkge1xuICAgICAgZXZlbnQucHJldmVudERlZmF1bHQoKTtcbiAgICB9XG4gIH1cblxuICBpc0Nocm9tZUFuZHJvaWQoKTogYm9vbGVhbiB7XG4gICAgcmV0dXJuIC9jaHJvbWUvaS50ZXN0KG5hdmlnYXRvci51c2VyQWdlbnQpICYmIC9hbmRyb2lkL2kudGVzdChuYXZpZ2F0b3IudXNlckFnZW50KTtcbiAgfVxuXG4gIGlzUmVhZE9ubHkoKTogYm9vbGVhbiB7XG4gICAgcmV0dXJuIHRoaXMuZWxlbWVudFJlZi5uYXRpdmVFbGVtZW50Lmhhc0F0dHJpYnV0ZSgncmVhZG9ubHknKVxuICB9XG5cbiAgcmVnaXN0ZXJPbkNoYW5nZShjYWxsYmFja0Z1bmN0aW9uOiBGdW5jdGlvbik6IHZvaWQge1xuICAgIHRoaXMuaW5wdXRIYW5kbGVyLnNldE9uTW9kZWxDaGFuZ2UoY2FsbGJhY2tGdW5jdGlvbik7XG4gIH1cblxuICByZWdpc3Rlck9uVG91Y2hlZChjYWxsYmFja0Z1bmN0aW9uOiBGdW5jdGlvbik6IHZvaWQge1xuICAgIHRoaXMuaW5wdXRIYW5kbGVyLnNldE9uTW9kZWxUb3VjaGVkKGNhbGxiYWNrRnVuY3Rpb24pO1xuICB9XG5cbiAgc2V0RGlzYWJsZWRTdGF0ZSh2YWx1ZTogYm9vbGVhbik6IHZvaWQge1xuICAgIHRoaXMuZWxlbWVudFJlZi5uYXRpdmVFbGVtZW50LmRpc2FibGVkID0gdmFsdWU7XG4gIH1cblxuICB3cml0ZVZhbHVlKHZhbHVlOiBudW1iZXIpOiB2b2lkIHtcbiAgICB0aGlzLmlucHV0SGFuZGxlci5zZXRWYWx1ZSh2YWx1ZSk7XG4gIH1cbn1cbiJdfQ==