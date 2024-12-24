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
package Hardware.CPU.Intel8086.Instructions.Misc;

import Hardware.CPU.Intel8086.Intel8086;
import Hardware.CPU.Intel8086.Instructions.Instruction;



public final class LOCK extends Instruction {
    
    private final Instruction m_instr;
    
    public LOCK(Intel8086 context,
                Instruction instr,
                int cycles) {
        
        super(context, cycles);
        
        m_instr = instr;
    }
    
    @Override
    public void run() {
        
        m_instr.run();
        
        m_cpu.updateClock(getCycles());
    }
    
    @Override
    public String toString() {
        
        return String.format("lock %s", m_instr.toString());
    }
}
