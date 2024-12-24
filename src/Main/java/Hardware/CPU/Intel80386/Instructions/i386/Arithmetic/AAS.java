/*
 * Copyright (C) 2017 h0MER247
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */
package Hardware.CPU.Intel80386.Instructions.i386.Arithmetic;

import Hardware.CPU.Intel80386.Instructions.Instruction;
import Hardware.CPU.Intel80386.Intel80386;



public final class AAS extends Instruction {

    public AAS(Intel80386 cpu) {
        
        super(cpu);
    }
    
    @Override
    public void run() {
        
        int ah = m_cpu.AH.getValue();
        int al = m_cpu.AL.getValue();
        
        if(((al & 0x0f) > 0x09) || m_cpu.FLAGS.AF) {

            ah = ah - 0x01;
            al = al - 0x06;
            
            m_cpu.AH.setValue(ah);
            m_cpu.AL.setValue(al & 0x0f);

            m_cpu.FLAGS.CF = true;
            m_cpu.FLAGS.AF = true;
        }
        else {
            
            m_cpu.AL.setValue(al & 0x0f);

            m_cpu.FLAGS.CF = false;
            m_cpu.FLAGS.AF = false;
        }
    }
    
    @Override
    public String toString() {
        
        return "aas";
    }
}
