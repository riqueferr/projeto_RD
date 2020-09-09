import { InputService } from "./input.service";
var InputHandler = /** @class */ (function () {
    function InputHandler(htmlInputElement, options) {
        this.inputService = new InputService(htmlInputElement, options);
    }
    InputHandler.prototype.handleCut = function (event) {
        var _this = this;
        setTimeout(function () {
            _this.inputService.updateFieldValue();
            _this.setValue(_this.inputService.value);
            _this.onModelChange(_this.inputService.value);
        }, 0);
    };
    InputHandler.prototype.handleInput = function (event) {
        var _this = this;
        var selectionStart = this.inputService.inputSelection.selectionStart;
        var keyCode = this.inputService.rawValue.charCodeAt(selectionStart - 1);
        var rawValueLength = this.inputService.rawValue.length;
        var storedRawValueLength = this.inputService.storedRawValue.length;
        if (Math.abs(rawValueLength - storedRawValueLength) != 1) {
            this.inputService.updateFieldValue(selectionStart);
            this.onModelChange(this.inputService.value);
            return;
        }
        // Restore the old value.
        this.inputService.rawValue = this.inputService.storedRawValue;
        if (rawValueLength < storedRawValueLength) {
            // Chrome Android seems to move the cursor in response to a backspace AFTER processing the
            // input event, so we need to wrap this in a timeout.
            this.timer(function () {
                // Move the cursor to just after the deleted value.
                _this.inputService.updateFieldValue(selectionStart + 1);
                // Then backspace it.
                _this.inputService.removeNumber(8);
                _this.onModelChange(_this.inputService.value);
            }, 0);
        }
        if (rawValueLength > storedRawValueLength) {
            // Move the cursor to just before the new value.
            this.inputService.updateFieldValue(selectionStart - 1);
            // Process the character like a keypress.
            this.handleKeypressImpl(keyCode);
        }
    };
    InputHandler.prototype.handleKeydown = function (event) {
        var keyCode = event.which || event.charCode || event.keyCode;
        if (keyCode == 8 || keyCode == 46 || keyCode == 63272) {
            event.preventDefault();
            if (this.inputService.inputSelection.selectionStart <= this.inputService.prefixLength() &&
                this.inputService.inputSelection.selectionEnd >= this.inputService.rawValue.length - this.inputService.suffixLength()) {
                this.clearValue();
            }
            else {
                this.inputService.removeNumber(keyCode);
                this.onModelChange(this.inputService.value);
            }
        }
    };
    InputHandler.prototype.clearValue = function () {
        this.setValue(this.inputService.isNullable() ? null : 0);
        this.onModelChange(this.inputService.value);
    };
    InputHandler.prototype.handleKeypress = function (event) {
        var keyCode = event.which || event.charCode || event.keyCode;
        event.preventDefault();
        if (keyCode === 97 && event.ctrlKey) {
            return;
        }
        this.handleKeypressImpl(keyCode);
    };
    InputHandler.prototype.handleKeypressImpl = function (keyCode) {
        switch (keyCode) {
            case undefined:
            case 9:
            case 13:
                return;
            case 43:
                this.inputService.changeToPositive();
                break;
            case 45:
                this.inputService.changeToNegative();
                break;
            default:
                if (this.inputService.canInputMoreNumbers) {
                    var selectionRangeLength = Math.abs(this.inputService.inputSelection.selectionEnd - this.inputService.inputSelection.selectionStart);
                    if (selectionRangeLength == this.inputService.rawValue.length) {
                        this.setValue(null);
                    }
                    this.inputService.addNumber(keyCode);
                }
                break;
        }
        this.onModelChange(this.inputService.value);
    };
    InputHandler.prototype.handlePaste = function (event) {
        var _this = this;
        setTimeout(function () {
            _this.inputService.updateFieldValue();
            _this.setValue(_this.inputService.value);
            _this.onModelChange(_this.inputService.value);
        }, 1);
    };
    InputHandler.prototype.updateOptions = function (options) {
        this.inputService.updateOptions(options);
    };
    InputHandler.prototype.getOnModelChange = function () {
        return this.onModelChange;
    };
    InputHandler.prototype.setOnModelChange = function (callbackFunction) {
        this.onModelChange = callbackFunction;
    };
    InputHandler.prototype.getOnModelTouched = function () {
        return this.onModelTouched;
    };
    InputHandler.prototype.setOnModelTouched = function (callbackFunction) {
        this.onModelTouched = callbackFunction;
    };
    InputHandler.prototype.setValue = function (value) {
        this.inputService.value = value;
    };
    /**
     * Passthrough to setTimeout that can be stubbed out in tests.
     */
    InputHandler.prototype.timer = function (callback, delayMillis) {
        setTimeout(callback, delayMillis);
    };
    return InputHandler;
}());
export { InputHandler };
//# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJmaWxlIjoiaW5wdXQuaGFuZGxlci5qcyIsInNvdXJjZVJvb3QiOiJuZzovL25neC1jdXJyZW5jeS8iLCJzb3VyY2VzIjpbInNyYy9pbnB1dC5oYW5kbGVyLnRzIl0sIm5hbWVzIjpbXSwibWFwcGluZ3MiOiJBQUFBLE9BQU8sRUFBQyxZQUFZLEVBQUMsTUFBTSxpQkFBaUIsQ0FBQztBQUU3QztJQU1JLHNCQUFZLGdCQUFrQyxFQUFFLE9BQVk7UUFDeEQsSUFBSSxDQUFDLFlBQVksR0FBRyxJQUFJLFlBQVksQ0FBQyxnQkFBZ0IsRUFBRSxPQUFPLENBQUMsQ0FBQztJQUNwRSxDQUFDO0lBRUQsZ0NBQVMsR0FBVCxVQUFVLEtBQVU7UUFBcEIsaUJBTUM7UUFMRyxVQUFVLENBQUM7WUFDUCxLQUFJLENBQUMsWUFBWSxDQUFDLGdCQUFnQixFQUFFLENBQUM7WUFDckMsS0FBSSxDQUFDLFFBQVEsQ0FBQyxLQUFJLENBQUMsWUFBWSxDQUFDLEtBQUssQ0FBQyxDQUFDO1lBQ3ZDLEtBQUksQ0FBQyxhQUFhLENBQUMsS0FBSSxDQUFDLFlBQVksQ0FBQyxLQUFLLENBQUMsQ0FBQztRQUNoRCxDQUFDLEVBQUUsQ0FBQyxDQUFDLENBQUM7SUFDVixDQUFDO0lBRUQsa0NBQVcsR0FBWCxVQUFZLEtBQVU7UUFBdEIsaUJBbUNDO1FBbENHLElBQUksY0FBYyxHQUFHLElBQUksQ0FBQyxZQUFZLENBQUMsY0FBYyxDQUFDLGNBQWMsQ0FBQztRQUNyRSxJQUFJLE9BQU8sR0FBRyxJQUFJLENBQUMsWUFBWSxDQUFDLFFBQVEsQ0FBQyxVQUFVLENBQUMsY0FBYyxHQUFHLENBQUMsQ0FBQyxDQUFDO1FBQ3hFLElBQUksY0FBYyxHQUFHLElBQUksQ0FBQyxZQUFZLENBQUMsUUFBUSxDQUFDLE1BQU0sQ0FBQztRQUN2RCxJQUFJLG9CQUFvQixHQUFHLElBQUksQ0FBQyxZQUFZLENBQUMsY0FBYyxDQUFDLE1BQU0sQ0FBQztRQUVuRSxJQUFJLElBQUksQ0FBQyxHQUFHLENBQUMsY0FBYyxHQUFHLG9CQUFv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LENBQUMsQ0FBQyxDQUFDO0lBQ1YsQ0FBQztJQUVELG9DQUFhLEdBQWIsVUFBYyxPQUFZO1FBQ3RCLElBQUksQ0FBQyxZQUFZLENBQUMsYUFBYSxDQUFDLE9BQU8sQ0FBQyxDQUFDO0lBQzdDLENBQUM7SUFFRCx1Q0FBZ0IsR0FBaEI7UUFDSSxPQUFPLElBQUksQ0FBQyxhQUFhLENBQUM7SUFDOUIsQ0FBQztJQUVELHVDQUFnQixHQUFoQixVQUFpQixnQkFBMEI7UUFDdkMsSUFBSSxDQUFDLGFBQWEsR0FBRyxnQkFBZ0IsQ0FBQztJQUMxQyxDQUFDO0lBRUQsd0NBQWlCLEdBQWpCO1FBQ0ksT0FBTyxJQUFJLENBQUMsY0FBYyxDQUFDO0lBQy9CLENBQUM7SUFFRCx3Q0FBaUIsR0FBakIsVUFBa0IsZ0JBQTBCO1FBQ3hDLElBQUksQ0FBQyxjQUFjLEdBQUcsZ0JBQWdCLENBQUM7SUFDM0MsQ0FBQztJQUVELCtCQUFRLEdBQVIsVUFBUyxLQUFhO1FBQ2xCLElBQUksQ0FBQyxZQUFZLENBQUMsS0FBSyxHQUFHLEtBQUssQ0FBQztJQUNwQyxDQUFDO0lBRUQ7O09BRUc7SUFDSyw0QkFBSyxHQUFiLFVBQWMsUUFBb0IsRUFBRSxXQUFtQjtRQUNuRCxVQUFVLENBQUMsUUFBUSxFQUFFLFdBQVcsQ0FBQyxDQUFDO0lBQ3RDLENBQUM7SUFDTCxtQkFBQztBQUFELENBQUMsQUF2SkQsSUF1SkMiLCJzb3VyY2VzQ29udGVudCI6WyJpbXBvcnQge0lucHV0U2VydmljZX0gZnJvbSBcIi4vaW5wdXQuc2VydmljZVwiO1xuXG5leHBvcnQgY2xhc3MgSW5wdXRIYW5kbGVyIHtcblxuICAgIHByaXZhdGUgaW5wdXRTZXJ2aWNlOiBJbnB1dFNlcnZpY2U7XG4gICAgcHJpdmF0ZSBvbk1vZGVsQ2hhbmdlOiBGdW5jdGlvbjtcbiAgICBwcml2YXRlIG9uTW9kZWxUb3VjaGVkOiBGdW5jdGlvbjtcblxuICAgIGNvbnN0cnVjdG9yKGh0bWxJbnB1dEVsZW1lbnQ6IEhUTUxJbnB1dEVsZW1lbnQsIG9wdGlvbnM6IGFueSkge1xuICAgICAgICB0aGlzLmlucHV0U2VydmljZSA9IG5ldyBJbnB1dFNlcnZpY2UoaHRtbElucHV0RWxlbWVudCwgb3B0aW9ucyk7XG4gICAgfVxuXG4gICAgaGFuZGxlQ3V0KGV2ZW50OiBhbnkpOiB2b2lkIHtcbiAgICAgICAgc2V0VGltZW91dCgoKSA9PiB7XG4gICAgICAgICAgICB0aGlzLmlucHV0U2VydmljZS51cGRhdGVGaWVsZFZhbHVlKCk7XG4gICAgICAgICAgICB0aGlzLnNldFZhbHVlKHRoaXMuaW5wdXRTZXJ2aWNlLnZhbHVlKTtcbiAgICAgICAgICAgIHRoaXMub25Nb2RlbENoYW5nZSh0aGlzLmlucHV0U2VydmljZS52YWx1ZSk7XG4gICAgICAgIH0sIDApO1xuICAgIH1cblxuICAgIGhhbmRsZUlucHV0KGV2ZW50OiBhbnkpOiB2b2lkIHtcbiAgICAgICAgbGV0IHNlbGVjdGlvblN0YXJ0ID0gdGhpcy5pbnB1dFNlcnZpY2UuaW5wdXRTZWxlY3Rpb24uc2VsZWN0aW9uU3RhcnQ7XG4gICAgICAgIGxldCBrZXlDb2RlID0gdGhpcy5pbnB1dFNlcnZpY2UucmF3VmFsdWUuY2hhckNvZGVBdChzZWxlY3Rpb25TdGFydCAtIDEpO1xuICAgICAgICBsZXQgcmF3VmFsdWVMZW5ndGggPSB0aGlzLmlucHV0U2VydmljZS5yYXdWYWx1ZS5sZW5ndGg7XG4gICAgICAgIGxldCBzdG9yZWRSYXdWYWx1ZUxlbmd0aCA9IHRoaXMuaW5wdXRTZXJ2aWNlLnN0b3JlZFJhd1ZhbHVlLmxlbmd0aDtcblxuICAgICAgICBpZiAoTWF0aC5hYnMocmF3VmFsdWVMZW5ndGggLSBzdG9yZWRSYXdWYWx1ZUxlbmd0aCkgIT0gMSkge1xuICAgICAgICAgICAgdGhpcy5pbnB1dFNlcnZpY2UudXBkYXRlRmllbGRWYWx1ZShzZWxlY3Rpb25TdGFydCk7XG4gICAgICAgICAgICB0aGlzLm9uTW9kZWxDaGFuZ2UodGhpcy5pbnB1dFNlcnZpY2UudmFsdWUpO1xuICAgICAgICAgICAgcmV0dXJuO1xuICAgICAgICB9XG5cbiAgICAgICAgLy8gUmVzdG9yZSB0aGUgb2xkIHZhbHVlLlxuICAgICAgICB0aGlzLmlucHV0U2VydmljZS5yYXdWYWx1ZSA9IHRoaXMuaW5wdXRTZXJ2aWNlLnN0b3JlZFJhd1ZhbHVlO1xuXG4gICAgICAgIGlmIChyYXdWYWx1ZUxlbmd0aCA8IHN0b3JlZFJhd1ZhbHVlTGVuZ3RoKSB7XG4gICAgICAgICAgICAvLyBDaHJvbWUgQW5kcm9pZCBzZWVtcyB0byBtb3ZlIHRoZSBjdXJzb3IgaW4gcmVzcG9uc2UgdG8gYSBiYWNrc3BhY2UgQUZURVIgcHJvY2Vzc2luZyB0aGVcbiAgICAgICAgICAgIC8vIGlucHV0IGV2ZW50LCBzbyB3ZSBuZWVkIHRvIHdyYXAgdGhpcyBpbiBhIHRpbWVvdXQuXG4gICAgICAgICAgICB0aGlzLnRpbWVyKCgpID0+IHtcbiAgICAgICAgICAgICAgICAvLyBNb3ZlIHRoZSBjdXJzb3IgdG8ganVzdCBhZnRlciB0aGUgZGVsZXRlZCB2YWx1ZS5cbiAgICAgICAgICAgICAgICB0aGlzLmlucHV0U2VydmljZS51cGRhdGVGaWVsZFZhbHVlKHNlbGVjdGlvblN0YXJ0ICsgMSk7XG5cbiAgICAgICAgICAgICAgICAvLyBUaGVuIGJhY2tzcGFjZSBpdC5cbiAgICAgICAgICAgICAgICB0aGlzLmlucHV0U2VydmljZS5yZW1vdmVOdW1iZXIoOCk7XG4gICAgICAgICAgICAgICAgdGhpcy5vbk1vZGVsQ2hhbmdlKHRoaXMuaW5wdXRTZXJ2aWNlLnZhbHVlKTsgIFxuICAgICAgICAgICAgfSwgMCk7XG4gICAgICAgIH1cblxuICAgICAgICBpZiAocmF3VmFsdWVMZW5ndGggPiBzdG9yZWRSYXdWYWx1ZUxlbmd0aCkge1xuICAgICAgICAgICAgLy8gTW92ZSB0aGUgY3Vyc29yIHRvIGp1c3QgYmVmb3JlIHRoZSBuZXcgdmFsdWUuXG4gICAgICAgICAgICB0aGlzLmlucHV0U2VydmljZS51cGRhdGVGaWVsZFZhbHVlKHNlbGVjdGlvblN0YXJ0IC0gMSk7XG5cbiAgICAgICAgICAgIC8vIFByb2Nlc3MgdGhlIGNoYXJhY3RlciBsaWtlIGEga2V5cHJlc3MuXG4gICAgICAgICAgICB0aGlzLmhhbmRsZUtleXByZXNzSW1wbChrZXlDb2RlKTtcbiAgICAgICAgfVxuICAgIH1cblxuICAgIGhhbmRsZUtleWRvd24oZXZlbnQ6IGFueSk6IHZvaWQge1xuICAgICAgICBsZXQga2V5Q29kZSA9IGV2ZW50LndoaWNoIHx8IGV2ZW50LmNoYXJDb2RlIHx8IGV2ZW50LmtleUNvZGU7XG4gICAgICAgIGlmIChrZXlDb2RlID09IDggfHwga2V5Q29kZSA9PSA0NiB8fCBrZXlDb2RlID09IDYzMjcyKSB7XG4gICAgICAgICAgICBldmVudC5wcmV2ZW50RGVmYXVsdCgpO1xuXG4gICAgICAgICAgICBpZiAodGhpcy5pbnB1dFNlcnZpY2UuaW5wdXRTZWxlY3Rpb24uc2VsZWN0aW9uU3RhcnQgPD0gdGhpcy5pbnB1dFNlcnZpY2UucHJlZml4TGVuZ3RoKCkgJiZcbiAgICAgICAgICAgICAgICB0aGlzLmlucHV0U2VydmljZS5pbnB1dFNlbGVjdGlvbi5zZWxlY3Rpb25FbmQgPj0gdGhpcy5pbnB1dFNlcnZpY2UucmF3VmFsdWUubGVuZ3RoIC0gdGhpcy5pbnB1dFNlcnZpY2Uuc3VmZml4TGVuZ3RoKCkpIHtcbiAgICAgICAgICAgICAgICB0aGlzLmNsZWFyVmFsdWUoKTtcbiAgICAgICAgICAgIH0gZWxzZSB7XG4gICAgICAgICAgICAgICAgdGhpcy5pbnB1dFNlcnZpY2UucmVtb3ZlTnVtYmVyKGtleUNvZGUpO1xuICAgICAgICAgICAgICAgIHRoaXMub25Nb2RlbENoYW5nZSh0aGlzLmlucHV0U2VydmljZS52YWx1ZSk7XG4gICAgICAgICAgICB9XG4gICAgICAgIH1cbiAgICB9XG5cbiAgICBjbGVhclZhbHVlKCkge1xuICAgICAgICB0aGlzLnNldFZhbHVlKHRoaXMuaW5wdXRTZXJ2aWNlLmlzTnVsbGFibGUoKSA/IG51bGwgOiAwKTtcbiAgICAgICAgdGhpcy5vbk1vZGVsQ2hhbmdlKHRoaXMuaW5wdXRTZXJ2aWNlLnZhbHVlKTtcbiAgICB9XG5cbiAgICBoYW5kbGVLZXlwcmVzcyhldmVudDogYW55KTogdm9pZCB7XG4gICAgICAgIGxldCBrZXlDb2RlID0gZXZlbnQud2hpY2ggfHwgZXZlbnQuY2hhckNvZGUgfHwgZXZlbnQua2V5Q29kZTtcbiAgICAgICAgZXZlbnQucHJldmVudERlZmF1bHQoKTtcbiAgICAgICAgaWYgKGtleUNvZGUgPT09IDk3ICYmIGV2ZW50LmN0cmxLZXkpIHtcbiAgICAgICAgICAgIHJldHVybjtcbiAgICAgICAgfVxuXG4gICAgICAgIHRoaXMuaGFuZGxlS2V5cHJlc3NJbXBsKGtleUNvZGUpO1xuICAgIH1cblxuICAgIHByaXZhdGUgaGFuZGxlS2V5cHJlc3NJbXBsKGtleUNvZGU6IG51bWJlcik6IHZvaWQge1xuICAgICAgICBzd2l0Y2ggKGtleUNvZGUpIHtcbiAgICAgICAgICAgIGNhc2UgdW5kZWZpbmVkOlxuICAgICAgICAgICAgY2FzZSA5OlxuICAgICAgICAgICAgY2FzZSAxMzpcbiAgICAgICAgICAgICAgICByZXR1cm47XG4gICAgICAgICAgICBjYXNlIDQzOlxuICAgICAgICAgICAgICAgIHRoaXMuaW5wdXRTZXJ2aWNlLmNoYW5nZVRvUG9zaXRpdmUoKTtcbiAgICAgICAgICAgICAgICBicmVhaztcbiAgICAgICAgICAgIGNhc2UgNDU6XG4gICAgICAgICAgICAgICAgdGhpcy5pbnB1dFNlcnZpY2UuY2hhbmdlVG9OZWdhdGl2ZSgpO1xuICAgICAgICAgICAgICAgIGJyZWFrO1xuICAgICAgICAgICAgZGVmYXVsdDpcbiAgICAgICAgICAgICAgICBpZiAodGhpcy5pbnB1dFNlcnZpY2UuY2FuSW5wdXRNb3JlTnVtYmVycykge1xuICAgICAgICAgICAgICAgICAgICBsZXQgc2VsZWN0aW9uUmFuZ2VMZW5ndGggPSBNYXRoLmFicyh0aGlzLmlucHV0U2VydmljZS5pbnB1dFNlbGVjdGlvbi5zZWxlY3Rpb25FbmQgLSB0aGlzLmlucHV0U2VydmljZS5pbnB1dFNlbGVjdGlvbi5zZWxlY3Rpb25TdGFydCk7XG5cbiAgICAgICAgICAgICAgICAgICAgaWYgKHNlbGVjdGlvblJhbmdlTGVuZ3RoID09IHRoaXMuaW5wdXRTZXJ2aWNlLnJhd1ZhbHVlLmxlbmd0aCkge1xuICAgICAgICAgICAgICAgICAgICAgICAgdGhpcy5zZXRWYWx1ZShudWxsKTtcbiAgICAgICAgICAgICAgICAgICAgfVxuXG4gICAgICAgICAgICAgICAgICAgIHRoaXMuaW5wdXRTZXJ2aWNlLmFkZE51bWJlcihrZXlDb2RlKTtcbiAgICAgICAgICAgICAgICB9XG4gICAgICAgICAgICAgICAgYnJlYWs7XG4gICAgICAgIH1cblxuICAgICAgICB0aGlzLm9uTW9kZWxDaGFuZ2UodGhpcy5pbnB1dFNlcnZpY2UudmFsdWUpO1xuICAgIH1cblxuICAgIGhhbmRsZVBhc3RlKGV2ZW50OiBhbnkpOiB2b2lkIHtcbiAgICAgICAgc2V0VGltZW91dCgoKSA9PiB7XG4gICAgICAgICAgICB0aGlzLmlucHV0U2VydmljZS51cGRhdGVGaWVsZFZhbHVlKCk7XG4gICAgICAgICAgICB0aGlzLnNldFZhbHVlKHRoaXMuaW5wdXRTZXJ2aWNlLnZhbHVlKTtcbiAgICAgICAgICAgIHRoaXMub25Nb2RlbENoYW5nZSh0aGlzLmlucHV0U2VydmljZS52YWx1ZSk7XG4gICAgICAgIH0sIDEpO1xuICAgIH1cblxuICAgIHVwZGF0ZU9wdGlvbnMob3B0aW9uczogYW55KTogdm9pZCB7XG4gICAgICAgIHRoaXMuaW5wdXRTZXJ2aWNlLnVwZGF0ZU9wdGlvbnMob3B0aW9ucyk7XG4gICAgfVxuXG4gICAgZ2V0T25Nb2RlbENoYW5nZSgpOiBGdW5jdGlvbiB7XG4gICAgICAgIHJldHVybiB0aGlzLm9uTW9kZWxDaGFuZ2U7XG4gICAgfVxuXG4gICAgc2V0T25Nb2RlbENoYW5nZShjYWxsYmFja0Z1bmN0aW9uOiBGdW5jdGlvbik6IHZvaWQge1xuICAgICAgICB0aGlzLm9uTW9kZWxDaGFuZ2UgPSBjYWxsYmFja0Z1bmN0aW9uO1xuICAgIH1cblxuICAgIGdldE9uTW9kZWxUb3VjaGVkKCk6IEZ1bmN0aW9uIHtcbiAgICAgICAgcmV0dXJuIHRoaXMub25Nb2RlbFRvdWNoZWQ7XG4gICAgfVxuXG4gICAgc2V0T25Nb2RlbFRvdWNoZWQoY2FsbGJhY2tGdW5jdGlvbjogRnVuY3Rpb24pIHtcbiAgICAgICAgdGhpcy5vbk1vZGVsVG91Y2hlZCA9IGNhbGxiYWNrRnVuY3Rpb247XG4gICAgfVxuXG4gICAgc2V0VmFsdWUodmFsdWU6IG51bWJlcik6IHZvaWQge1xuICAgICAgICB0aGlzLmlucHV0U2VydmljZS52YWx1ZSA9IHZhbHVlO1xuICAgIH1cblxuICAgIC8qKlxuICAgICAqIFBhc3N0aHJvdWdoIHRvIHNldFRpbWVvdXQgdGhhdCBjYW4gYmUgc3R1YmJlZCBvdXQgaW4gdGVzdHMuXG4gICAgICovXG4gICAgcHJpdmF0ZSB0aW1lcihjYWxsYmFjazogKCkgPT4gdm9pZCwgZGVsYXlNaWxsaXM6IG51bWJlcikge1xuICAgICAgICBzZXRUaW1lb3V0KGNhbGxiYWNrLCBkZWxheU1pbGxpcyk7XG4gICAgfVxufVxuIl19