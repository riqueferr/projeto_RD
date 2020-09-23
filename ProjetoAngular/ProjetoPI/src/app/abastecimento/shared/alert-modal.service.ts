import { Injectable } from '@angular/core';
import { BsModalService, BsModalRef } from 'ngx-bootstrap/modal';
import { AlertModalComponent } from './alert-modal/alert-modal.component';

export enum AlertTypes{
    DANGER = 'danger',
    SUCCESS = 'success'
}

@Injectable({
  providedIn: 'root'
})
export class AlertModalService {

  constructor(
    private modalService: BsModalService
  ) { }

  private showAllert(message: string, type: AlertTypes, dismissTimout?: number){
    const bsModalRef: BsModalRef = this.modalService.show(AlertModalComponent);
    bsModalRef.content.type = type;
    bsModalRef.content.message = message;

    if(dismissTimout){
        setTimeout(() => bsModalRef.hide(), dismissTimout);
    }

  }

  showAlertDanger(message: string){
        this.showAllert(message, AlertTypes.DANGER)
  }

  showAlertSuccess(message: string){
    this.showAllert(message, AlertTypes.SUCCESS)
}

}
